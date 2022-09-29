const Router = require("express");
const { models } = require("../db");
const artController = require("../controllers/artController");
const authMiddleware = require("../middleware/authMiddleware");
const checkRoleMiddleware = require("../middleware/checkRoleMiddleware");

const router = new Router();

router.post("/", authMiddleware, artController.create);
router.get("/", checkRoleMiddleware("AUTHOR").getAll);
router.get("/:id", artController.getOne);
router.delete("/:id", authMiddleware, artController.deleteArt);

module.exports = router;
