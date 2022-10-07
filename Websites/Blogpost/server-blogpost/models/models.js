const sequelize = require("../db");
const { DataTypes } = require("sequelize");
const { INTEGER } = require("sequelize");
const { Sequelize } = require("../db");

const User = sequelize.define("user", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
  alias: { type: DataTypes.STRING, unique: true },
  email: { type: DataTypes.STRING, unique: true },
  avatar: { type: DataTypes.STRING },
  password: { type: DataTypes.STRING },
  role: { type: DataTypes.STRING, defaultValue: "READER" },
});

const Blog = sequelize.define("blog", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
  date: {
    type: Sequelize.DATEONLY,
    allowNull: false,
    defaultValue: Sequelize.NOW,
  },
  header: { type: DataTypes.STRING },
  body: { type: DataTypes.TEXT },
  photo: { type: DataTypes.STRING },
  video: { type: DataTypes.STRING, allowNull: true },
  rating: { type: DataTypes.INTEGER, defaultValue: 0 },
});

const Art = sequelize.define("art", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
  date: {
    type: Sequelize.DATEONLY,
    allowNull: false,
    defaultValue: Sequelize.NOW,
  },
  header: { type: DataTypes.STRING, unique: true },
  body: { type: DataTypes.TEXT },
  photo: { type: DataTypes.STRING },
  price: { type: DataTypes.FLOAT, defaultValue: 0 },
  rating: { type: DataTypes.INTEGER, defaultValue: 0 },
});

const Comment = sequelize.define("comment", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
  date: {
    type: Sequelize.DATEONLY,
    allowNull: false,
    defaultValue: Sequelize.NOW,
  },
  body: { type: DataTypes.STRING, allowNull: false },
  alias: { type: DataTypes.STRING },
  approved: {type: DataTypes.BOOLEAN, defaultValue:false}
});

const Hashtag = sequelize.define("hashtag", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
  name: { type: DataTypes.STRING, unique: true },
  
});

const Rating = sequelize.define("rating", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
  rating: { type: DataTypes.INTEGER, allowNull: false },
});

const BlogHashtag = sequelize.define("blog_hashtag", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
});

const ArtHashtag = sequelize.define("art_hashtag", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
});

const Basket = sequelize.define("basket", {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
})

const BasketItem = sequelize.define("basket_item",{
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
})

User.hasOne(Basket);
Basket.belongsTo(User);

Basket.hasMany(BasketItem);
BasketItem.belongsTo(Basket)

Art.hasMany(BasketItem);
BasketItem.belongsTo(Art);

Blog.hasMany(Comment);
Comment.belongsTo(Blog);
//HASHTAG
Hashtag.belongsToMany(Blog, { through: BlogHashtag });
Blog.belongsToMany(Hashtag, { through: BlogHashtag });

Blog.hasMany(Rating);
Rating.belongsTo(Blog);

Art.hasMany(Comment);
Comment.belongsTo(Art);
//HASHTAG
Hashtag.belongsToMany(Art, { through: ArtHashtag });
Art.belongsToMany(Hashtag, { through: ArtHashtag });

Art.hasMany(Rating);
Rating.belongsTo(Art);

User.hasMany(Comment);
Comment.belongsTo(User);
User.hasMany(Rating);
Rating.belongsTo(User);

module.exports = {
  User,
  Basket,
  BasketItem,
  Blog,
  Art,
  Comment,
  Hashtag,
  Rating,
};
