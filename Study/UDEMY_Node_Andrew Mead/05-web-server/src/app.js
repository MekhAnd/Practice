const path = require("path");
const express = require("express");
const hbs = require("hbs");

const app = express();

//Define path for Express config 
const publicDirectoryPath = path.join(__dirname, "../public");
const viewsPath = path.join(__dirname, "../templates/views");
const partialsPath = path.join(__dirname, "../templates/partials")

//Setup handlers engine and views locations
app.set("views", viewsPath);
app.set("view engine", "hbs");
hbs.registerPartials(partialsPath)

//Setup static directory to server
app.use(express.static(publicDirectoryPath));

/** if we do not use express.static for index.html*/
// app.get("",(req,res)=>{
//     res.send("<h1>Weather</h1>")
// })

// app.get("/help", (req,res)=>{
//     res.send("Help page")
// })

// app.get("/about", (req,res)=>{
//     res.send("<h1>About</h1>")
// })


app.get("", (req, res) => {
  res.render("index", {
    title: "Weather",
    name: "Andrii Mekhanich"
  });
});

app.get("/about", (req, res) => {
  res.render("about", {
    title: "Weather",
    name: "Andrii Mekhanich"
  });
});

app.get("/help", (req, res) => {
  res.render("help", {
    helpMsg: "Would you need a help?",
    title:"Help",
    name: "Andrii Mekhanich"
  });
});

app.get("/weather", (req, res) => {
  res.send({ location: "Kyiv", weather: "13" });
});

app.get("/help/*",(req,res)=>{
    res.render("404page", {
      title:"Weather",
      errorMsg: "Help article not found",
      name: "Andrii Mekhanich"
    })
})

app.get('*',(req,res)=>{
    res.render("404page",{
      title:"Weather",
      errorMsg:"Page not found",
      name: "Andrii Mekhanich"
    })
})

app.listen(3001, () => {
  console.log("Server is up on port 3001");
});
