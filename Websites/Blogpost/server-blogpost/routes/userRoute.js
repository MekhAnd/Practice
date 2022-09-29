const Router = require ("express");
const { models } = require("../db");
const userController = require("../controllers/userController")
const authMiddleware = require("../middleware/authMiddleware");
const checkRoleMiddleware = require("../middleware/checkRoleMiddleware");
const router = new Router();


router.post("/registration", userController.registration)
router.post("/login", userController.login)
router.patch("/", checkRoleMiddleware("ADMIN"), userController.updateUserInfo);
router.get("/auth", authMiddleware, userController.check)
router.get("/", checkRoleMiddleware("ADMIN"), userController.getAudience)
router.delete("/:id", checkRoleMiddleware("ADMIN"), userController.deleteUser) //
router.get("/:id", userController.getUser)


module.exports = router;