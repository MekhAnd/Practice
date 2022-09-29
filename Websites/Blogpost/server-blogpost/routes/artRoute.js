const Router = require("express");
const { models } = require("../db");
const artController = require("../controllers/artController");
const roleMiddleware = require("../middleware/checkRoleMiddleware");

const router = new Router();

router.post("/", roleMiddleware("AUTHOR"), artController.create);
router.patch("/", roleMiddleware("AUTHOR"), artController.updateArt);
router.get("/", artController.getAll);
router.get("/:id", artController.getOne);
router.delete("/:id", roleMiddleware("AUTHOR"), artController.deleteArt);

module.exports = router;
