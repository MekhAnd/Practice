const { Rating } = require("../models/models");
const ApiErrors = require("../error/ApiError")

class RatingController {
  async create(req, res) {
    const { rating } = req.body;
    const ratings = await Rating.create({ rating });
    return res.json(ratings);
  }

  async getAll(req, res) {
    const ratings = await Rating.findAll()
  }
}

module.exports = new RatingController();
