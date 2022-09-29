const fs = require("fs");

// const book = {
//     title:"Ego is the Enemy",
//     author: "Ryan Holiday"
// }

// const bookJSON = JSON.stringify(book) //is the STRING!!!
// fs.writeFileSync("1-json.json", bookJSON)

// const dataBufer = fs.readFileSync('1-json.json');
// console.log(dataBufer)
// const dataToJSON = dataBufer.toString(); //to JSON.stringify()
// const dataToJSON_II = JSON.parse(dataBufer) //to JSON can be som truble with incoming data
// console.log(dataBufer.toString())
// console.log(dataToJSON.toString())
// console.log(dataToJSON_II)

// const bookPARSE = JSON.parse(bookJSON) //back JSONString to JSON

// console.log(bookJSON)
// console.log(bookPARSE)

const andrewData = fs.readFileSync("1-json.json")
const andrewStringFromBufer = andrewData.toString();
const andrewJSONfromString = JSON.parse(andrewStringFromBufer);

console.log(andrewJSONfromString);

andrewJSONfromString.name = "Andrii";
andrewJSONfromString.age = 46

console.log(andrewJSONfromString);

const andriiStringify = JSON.stringify(andrewJSONfromString);
fs.writeFileSync("1-json.json", andriiStringify);
