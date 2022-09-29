const uuid = require("uuid");
const path = require("path");

const { Art } = require("../models/models");
const ApiError = require("../error/ApiError");
const { rmSync } = require("fs");

class ArtController {
  async create(req, res, next) {
    try {
      const { header, body, price, hashtag } = req.body;
      const { photo } = req.files;
      let imageName = `${uuid.v4()}.jpg`;
      photo.mv(path.resolve(__dirname, "..", "static/art_img", imageName));

      const art = await Art.create({
        header,
        body,
        photo: imageName,
        price,
        hashtag,
      });
      return res.json(art);
    } catch (error) {
      console.log(error);
      next(ApiError.badRequest(error.message));
    }
  }

  async updateArt(req, res, next) {
    try {
      let updating
      const { id, header, body, price } = req.body;
      const stateArray = [header, body, price];
      const fieldArray = ["header", "body", "price"];

      for(let i=0; i<stateArray.length; i++){
        if(stateArray[i] !== "undefined" && i===0){
          updating = await Art.update(
            {
              header:stateArray[i]
            },
            {where: {id:id}}
          )
        } else if(stateArray[i] !== "undefined" && i===1){
          updating = await Art.update(
            {
              body:stateArray[i]
            },
            {where: {id:id}}
          )
        } else if(stateArray[i] !== "undefined" && i===2){
          updating = await Art.update(
            {
              price:stateArray[i]
            },
            {where: {id:id}}
          )
        }
      }
      
      return res.json(updating);
    } catch (error) {
      console.log(error);
      next(ApiError.badRequest(error.message));
    }
  }

  async getAll(req, res) {
    const arts = await Art.findAll();
    return res.json(arts);
  }
  async getOne(req, res) {}

  async deleteArt(req, res, next) {
    try {
      const id = req.params.id;
      const deleting = await Art.destroy({ where: { id: id } });
      return res.json(deleting);
    } catch (error) {
      console.log(error);
      next(ApiError.badRequest(error.message));
    }
  }
}

module.exports = new ArtController();
