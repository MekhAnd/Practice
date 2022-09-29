const ApiError = require("../error/ApiError");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const uuid = require("uuid");
const path = require("path");

const { User, Comment } = require("../models/models");

const generateJWT = (id, email, role, alias) => {
  return jwt.sign({ id, email, role, alias }, process.env.AUTH_KEY, {
    expiresIn: "1h",
  });
};

class UserController {
  async registration(req, res, next) {
    const { email, password, alias, role } = req.body;

    if (!email || !password) {
      return next(ApiError.badRequest("Incorrect e-mail or password"));
    }
    const currentUser = await User.findOne({ where: { email: email } });
    if (currentUser) {
      return next(
        ApiError.badRequest(`User with this ${email} already exists`)
      );
    }
    const hashPass = await bcrypt.hash(password, 7);
    // console.log(req.files);
    // if (req.files) {
    //   const { avatar } = req.files;
    //   let imageName = `${uuid.v4()}.jpg`;
    //   avatar.mv(path.resolve(__dirname, "..", "static/ava_img", imageName));
    // } else {
    //   const { avatar } = null || {};
    //   let imageName = `ava.jpg`;
    //   avatar.mv(path.resolve(__dirname, "..", "static/ava_img", imageName));
    // }

    const user = await User.create({
      email,
      role,
      alias,
      // avatar: imageName,
      password: hashPass,
    });
    const token = generateJWT(user.id, user.email, user.role, user.alias);
    return res.json({ token, user });
  }

  async login(req, res, next) {
    const { email, password } = req.body;
    const currentUser = await User.findOne({ where: { email: email } });
    if (!currentUser) {
      return next(
        ApiError.badRequest(`Check this email ${email} or register a new user`)
      );
    }
    let passwordChecker = bcrypt.compareSync(password, currentUser.password);
    if (!passwordChecker) {
      return next(ApiError.badRequest(`Check your password`));
    }
    const token = generateJWT(
      currentUser.id,
      currentUser.email,
      currentUser.role,
      currentUser.alias,

    );
    return res.json({ token });
  }

  async check(req, res, next) {
    const token = generateJWT(req.user.id, req.user.email, req.user.role, req.user.alias);
    res.json({ token });
  }

  async getUser(req,res){
    const id=(req.params.id)
    const user = await User.findOne({where:{id:id}});
    return res.json(user);
  }

  async deleteUser(req,res,next){
    try {
      const id=(req.params.id)
      const user = await User.destroy({where:{id:id}});
      return res.json(user);
    } catch (error) {
      console.log(error)
      next(ApiError.badRequest(error.message));
    }
  }

  async getAudience(req,res){
    // console.log(req)
    const audience = await User.findAll();
    return res.json(audience);
  }

  async updateUserInfo (req, res,next){
    try {
      const {id, role} = req.body
      const updateUserRole = await User.update(
        {
          role:role
        },
        {
          where:{id:id}
        }
      )
    } catch (error) {
      console.log(error);
      next(ApiError.badRequest(error.message));
    }

  }
}



module.exports = new UserController();
