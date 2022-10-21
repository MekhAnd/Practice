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
  rating: 5,
};

const { label: productLabel, stock, price, rating = 5 } = product;
console.log(productLabel);
console.log(rating); //can add new variable or can use like default value for some prop of object

const transaction = (type, { label, stock }) => {
  console.log(type, label, stock);
};

transaction ("order", product) //clg=> "order Red notebook 201"
// transaction ("order") //clg=> "const transaction = (type, { label, stock }) => {TypeError: Cannot destructure property 'label' of 'undefined' as it is undefinedred notebook..."

const transaction02 = (type, { label, stock=0 }={}) => {
  console.log(type, label, stock);
};

transaction02 ("order", product) //clg=> "order Red notebook 201"
transaction02 ("order") //clg=> "order undefined undefined"

