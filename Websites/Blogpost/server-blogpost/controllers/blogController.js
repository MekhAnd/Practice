const uuid = require("uuid");
const path = require("path");

const { Blog } = require("../models/models");
const ApiError = require("../error/ApiError");

class BlogController {
  async create(req, res, next) {
    try {
      const { header, body, video, hashtag } = req.body;

      const { photo } = req.files;
      let imageName = `${uuid.v4()}.jpg`;
      photo.mv(path.resolve(__dirname, "..", "static/blog_img", imageName));
      const blog = await Blog.create({
        header,
        body,
        photo: imageName,
        video,
        hashtag,
      });
      return res.json(blog);
    } catch (error) {
      console.log(error);
      next(ApiError.badRequest(error.message));
    }
  }

  async updateBlog(req, res, next) {
    try {
      let updating
      const { id, header, body } = req.body;
      if (header === "" && body !== "") {
        updating = await Blog.update(
          {
            body: body,
          },
          { where: { id: id } }
        );
      } else if (body === "" && header !== "") {
        updating = await Blog.update(
          {
            header: header,
          },
          { where: { id: id } }
        );
      } else if (body === "" && header === "") {
        console.log("There is nothing to update");
      } else {
        updating = await Blog.update(
          { header: header, body: body },
          { where: { id: id } }
        );
      }
      return res.json(updating);
    } catch (error) {
      console.log(error);
      next(ApiError.badRequest(error.message));
    }
  }

  async deleteBlog(req, res, next) {
    try {
      const id = req.params.id;
      const deleting = await Blog.destroy({ where: { id: id } });
      return res.json(deleting);
    } catch (error) {
      console.log(error);
      next(ApiError.badRequest(error.message));
    }
  }

  async getAll(req, res) {
    // let { limit, page } = req.query;
    // page = page || 1;
    // limit = limit || 6;
    // let offset = page*limit - limit
    const blogs = await Blog.findAll(); //limit, offset
    return res.json(blogs);
  }

  async getOne(req, res) {
    const id = req.params.id;
    const blog = await Blog.findOne({ where: { id: id } });
    return res.json(blog);
  }

  async delete(req, res) {}
}

module.exports = new BlogController();
