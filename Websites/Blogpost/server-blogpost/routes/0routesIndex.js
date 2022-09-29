const Router = require("express");
const { models } = require("../db");
const router = new Router();

const artRoute = require("./artRoute");
const blogRoute = require("./blogRoute");
const commentRoute = require("./commentRoute");
const hashtagRoute = require("./hashtagRoute");
const ratingRoute = require("./ratingRoutes");
const userRoute = require("./userRoute");

router.use("/art", artRoute);
router.use("/blog", blogRoute);
router.use("/comment", commentRoute);
router.use("/hashtag", hashtagRoute);
router.use("/rating", ratingRoute);
router.use("/user", userRoute);

module.exports = router;
