require("dotenv").config();
const express = require("express");
const sequelize = require("./db");
const dbModels = require("./models/models");
const cors = require("cors");
const fileUpload  = require("express-fileupload");
const path = require("path")

const router = require("./routes/0routesIndex");
const errorHandler = require("./middleware/ErrorHandlingMiddleware");

const app = express();
const PORT = process.env.PORT;

app.use(cors());
app.use(express.json());
app.use(express.static(path.resolve(__dirname, "static/blog_img")))
app.use(express.static(path.resolve(__dirname, "static/art_img")))
app.use(express.static(path.resolve(__dirname, "static/ava_img")))
app.use(fileUpload({}))
app.use("/api", router);


app.use(errorHandler);


const startDB = async () => {
  try {
    await sequelize.authenticate().then(console.log("Connected"));
    await sequelize.sync().then(console.log("Base syncronized"));

    app.listen(PORT || 5000, () => {
      console.log(`Server started on port ${PORT}`);
    });
  } catch (error) {
    console.log(error);
  }
};

startDB();

app.get("/", (req, res) => {
  res.send("Hi!!!");
});
