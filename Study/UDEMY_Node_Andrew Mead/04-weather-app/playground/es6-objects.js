//Object prop shorthand

const name = "Andrii";
const userAge = 46;

const user = {
  name, //shorthand just - name
  age: userAge,
  location: "Kyiv",
};
console.log(user);

//destructuring

const product = {
  label: "Red notebook",
  price: 3,
  stock: 201,
  salesPrice: undefined,
};

const { label: productLabel, stock, price, rating = 5 } = product;
console.log(productLabel)
console.log(rating) //can add new variable or can use like default value for some prop of object 

