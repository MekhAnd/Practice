const Router = require ("express");
const { models } = require("../db");
const hashTagController = require ("../controllers/hashtagController")

const router = new Router();

router.post("/", hashTagController.createTag)
router.post("/connect", hashTagController.connectTag)
router.get("/", hashTagController.getAll)
router.get("/:id", hashTagController.getTagged)


module.exports = router;