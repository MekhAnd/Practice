const Router = require ("express");
const { models } = require("../db");
const commentController = require("../controllers/commentController")
const roleMiddleware = require("../middleware/checkRoleMiddleware");

const router = new Router();

router.post("/", commentController.create)
router.post("/:id", commentController.approveComment)
router.get("/blog/:id", commentController.getAllBlogComments)
router.get("/art/:id", commentController.getAllArtComments)
router.get("/", commentController.getAllComments)
router.delete("/:id", roleMiddleware("AUTHOR"), commentController.deleteComment);


module.exports = router;