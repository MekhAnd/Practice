const Router = require("express");
const { models } = require("../db");
const blogController = require("../controllers/blogController");
const roleMiddleware = require("../middleware/checkRoleMiddleware");

const router = new Router();

router.post("/", roleMiddleware("AUTHOR"), blogController.create);
router.patch("/", roleMiddleware("AUTHOR"), blogController.updateBlog);
router.get("/", blogController.getAll);
router.get("/:id", blogController.getOne);
router.delete("/:id", roleMiddleware("AUTHOR"), blogController.deleteBlog);

module.exports = router;
