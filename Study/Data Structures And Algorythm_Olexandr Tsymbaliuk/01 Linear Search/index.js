`use strict`;

const linearSearchArray = [];
const arrayLength = Math.round(Math.random() * 100_000);

console.log(arrayLength);

for (let i = 0; i < 1_000_000; i++) {
  linearSearchArray[i] = Math.round(Math.random() * 100_000);
}

console.log(linearSearchArray);

function standartSearch(array, element) {
  for (let i = 0; i < array.length; i++) {
    if (array[i] === element) {
      console.log("FOUND IT", arrayLength, [i]);
      return i;
    }
  }
  console.log("Element wasn`t found");
  return -1;
}

function modStandartSearch(array, element) {
  array.push(element);
  let i = 0;
  for (; array[i] !== element; ) {
    i++;
  }
  array.splice(array.length, 1);
 if (i===array.length){
    console.log("Element ", element, " was not found")
    return -1
  } else{
    console.log("Element ", element, " was found on position ", i)
    return i
  }
}

let standartStart = new Date().getMilliseconds()
standartSearch(linearSearchArray, arrayLength);
let standartStop = new Date().getMilliseconds()

console.log("res in milsec =>", standartStop-standartStart)

let modStart = new Date().getMilliseconds()
modStandartSearch(linearSearchArray, arrayLength);
let modStop = new Date().getMilliseconds()

console.log("res in milsec =>", modStop-modStart)


let functStart = new Date().getMilliseconds()
let res = linearSearchArray.find((element)=>{return element === arrayLength})
let functStop = new Date().getMilliseconds()

console.log("res in milsec =>", functStop-functStart)

//res 0.16-0.19 sec
