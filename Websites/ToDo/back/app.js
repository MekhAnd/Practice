require('dotenv').config()
const express = require("express");
const axios = require("axios");
const mongoose = require("mongoose");
const session = require("express-session");
const passport = require("passport");
const passportLocalMongoose = require("passport-local-mongoose");

const app = express();

let currentUserId = {};

app.use(express.static(__dirname + "/static"));
app.use(express.json({ linit: "1mb" }));

app.use(
  session({
    secret:  process.env.KEY_SECRET,
    resave: false,
    saveUninitialized: false,
    cookie: { secure: true },
  })
);
app.use(passport.initialize());
app.use(passport.session());

main().catch((err) => console.log(err));
async function main() {
  await mongoose.connect(`mongodb+srv://andrii_mekhanich:${process.env.KEY_MONGODB}@cluster0.d9rsa.mongodb.net/dayScheduleDB`);
}

const userAuthSchema = new mongoose.Schema({
  username: {
    type: String,
    required: true,
    trim: true,
  },
  userpass: {
    type: String,
    minlength: 5,
  },
});

const scheduleSchema = new mongoose.Schema({
  key: Number,
  date: Number,
  body: String,
  user: String,
});

userAuthSchema.plugin(passportLocalMongoose);

const ItemSchema = mongoose.model("Item", scheduleSchema);
const UserSchema = mongoose.model("User", userAuthSchema);

passport.use(UserSchema.createStrategy());

passport.serializeUser(function (user, done) {
  done(null, user._id);
});

passport.deserializeUser(function (id, done) {
  User.findById(id, function (err, user) {
    console.log("deserializing user:", user);
    if (err) {
      done(err);
    } else {
      done(null, user);
    }
  });
});

app.get("/static/index.html", (req, res) => {
  res.sendFile(__dirname + "/static/index.html");
});

app.get("/static/register.html", (req, res) => {
  res.sendFile(__dirname + "/static/register.html");
});

app.get("/static/about.html", (req, res) => {
  res.sendFile(__dirname + "/static/about.html");
});

app.post("/getforecast", (req,res)=>{
  axios
    .get(`https://api.openweathermap.org/data/2.5/forecast?lat=${req.body.latitude}&lon=${req.body.longitude}&appid=${process.env.KEY_API}&units=metric`)
    .then((response)=> {
      res.send(response.data)
    })
    .catch(function (error) {
      console.log(error);
    })
    
})

app.post("/registration", (req, res) => {
  const username = req.body.userEmail;
  const userpassword = req.body.userPass;

  UserSchema.register({ username: username }, userpassword, (err, newUser) => {
    if (err) {
      console.log(err);
      res
        .status(400)
        .send({
          err: `User ${username} аlready exists`,
          status: 400,
        });
    } else {
      console.log("Ok")
      passport.authenticate("local")(req, res, () => {
        res.sendFile(__dirname + "/static/index.html");
      });
    }
  });
});

app.post("/login", (req, res) => {
  const user = new UserSchema({
    username: req.body.userEmail,
    userpass: req.body.userPass,
  });
  req.login(user, (err) => {
    if (err) {
      console.log(err);
    } else {
      res.status(200).send({ err: `Ok`, status: 200 });
      passport.authenticate("local")(req, res, () => {
        res.sendFile(__dirname + "/static/index.html");
      });
    }
  });
});

app.get("/", (req, res) => {
  res.sendFile("/");
});

app.post("/", (req, res) => {
  res.redirect("/");
});

app.post("/newItem/:currenUser", (req, res) => {
  const newTask = new ItemSchema({
    key: req.body.key,
    date: req.body.date,
    body: req.body.body,
    user: req.params.currenUser,
  });
  newTask.save();

  ItemSchema.find(
    { user: req.params.currenUser, date: req.body.date },
    (err, foundItems) => {
      if (err) {
        console.log(err);
      } else {
        res.send(foundItems);
      }
    }
  );
});

app.get("/itemsList/:dateParam/:currenUser", (req, res) => {
  ItemSchema.find({ date: req.params.dateParam }, (err, foundItems) => {
    if (err) {
      console.log(err);
    } else {
      const filterQ = req.params.currenUser;
      const filtred = foundItems.filter((element) => element.user === filterQ);
      res.send(filtred);
    }
  });
});

app.get("/delete/:itemIndex/:currentUser", (req, res) => {
  let keyInItem = req.params.itemIndex.split("_")[0];
  let dateInItem = req.params.itemIndex.split("_")[1];
  let username = req.params.currentUser;

  ItemSchema.findOneAndDelete(
    { username: username, key: keyInItem },
    (err, foundItems) => {
      // console.log("ItemSchema.findOneAndDelete", foundItems);
    }
  );
  ItemSchema.find(
    { username: username, date: dateInItem },
    (err, foundItems) => {
      if (err) {
        console.log(err);
      } else {
        res.send(foundItems);
      }
    }
  );
});

let port = process.env.PORT;
if (port == null || port == "") {
  port = 3000;
}

app.listen(port, () => {
  console.log("Server started!");
});
