const jwt = require("jsonwebtoken");
const { Comment } = require("../models/models");
const ApiError = require("../error/ApiError");

class CommentController {
  async create(req, res) {
    console.log("CREATE COMMENT")
    const { body, blogId, artId } = req.body;
      const token = req.headers.authorization.split(" ")[1];
      if (!token) {
        return res.status(401).json({ message: "The user is not authorized" });
      }
      const decoder = jwt.verify(token, process.env.AUTH_KEY)
      const userId = decoder.id;
      const userAlias = decoder.alias
      
   let comment;
    if (!blogId) {
      comment = await Comment.create({ body, blogId: null, artId, userId, alias:userAlias });
    } else if (!artId) {
      comment = await Comment.create({ body, blogId, artId: null, userId, alias:userAlias });
    }
    return res.json(comment);
  }

  async getAllBlogComments(req, res) {
    const blogId  = Number(req.params.id);
    const comments = await Comment.findAll({ where: { blogId: blogId , artId:null} });
    return res.json(comments);
  }

  async getAllArtComments(req, res) {
    const artId  = Number(req.params.id);
    const comments = await Comment.findAll({ where: { blogId: null , artId:artId} });
    return res.json(comments);
  }

  async getAllComments(req, res) {
    const comments = await Comment.findAll({ where: { approved: false } });
    return res.json(comments);
  }

  async approveComment(req, res) {
    let id = (req.params.id)
   
    let updateComment
    const marker = true
    
    try {
      updateComment = await Comment.update(
      {
        approved: marker,
      },
      { where: { id: id } });
    } catch (error) {
      console.log(error)
    }
    return res.json(updateComment);
  }

  async getOne(req, res) {}

  async deleteComment(req, res, next) {
    try {
      const id = req.params.id;
      const deleting = await Comment.destroy ({where:{id:id}})
      return res.json(deleting)
    } catch (error) {
      console.log(error);
      next(ApiError.badRequest(error.message));
    }
  }
}

module.exports = new CommentController();
