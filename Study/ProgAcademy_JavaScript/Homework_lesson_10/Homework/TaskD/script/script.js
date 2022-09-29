 /**
 * Класс, объекты которого описывают параметры гамбургера. 
 * 
 * @constructor
 * @param size        Размер
 * @param stuffing    Начинка
 * @throws {HamburgerException}  При неправильном использовании
 */

function Hamburger(size, stuffing) { 
   
  try {
    if(arguments.length!=2){
      throw new HamburgerException(`Mismatching in the number of arguments`);} 
    if(size.type != 'size'){ throw  new HamburgerException('Mismatching in type in the size parameter');}
    if(stuffing.type != 'stuff') {throw  new HamburgerException('Mismatching in type in the stuffing parameter');}
    this.size = size;
    this.stuffing = stuffing;
    this.toppingArray = [];   
    this.toPrint = function(){
          document.write(`SIZE = [${size.price}; ${size.value}, ${size.name}], STUFFING = [${stuffing.price}; ${stuffing.price}]`);
    }

  } catch (e) {
    console.log(`${e}`); 
      /*Скоріше за все необхідно виводити саме Object e, а не його name + message!?*/
  }  
} 

function Service (price, value, name, type)  {
    this.price = price;
    this.value = value;
    this.name = name;
    this.type = type;
}

  /* Размеры, виды начинок и добавок */

Hamburger.SIZE_SMALL = {price:50, value:20, name:'small', type:'size'};
Hamburger.SIZE_LARGE = {price:100, value:40, name:'large', type:'size'};
Hamburger.STUFFING_CHEESE = {price:10, value:20, name:'cheese', type:'stuff'};
Hamburger.STUFFING_SALAD = {price:10, value:20, name:'salad', type:'stuff'};
Hamburger.STUFFING_POTATO = {price:15, value:10, name:'potato', type:'stuff'};
Hamburger.TOPPING_MAYO = {price:20, value:5, name:'mayo', type:'top'};
Hamburger.TOPPING_SPICE = {price:15, value:0, name:'spice', type:'top'};

/**
* Добавить добавку к гамбургеру. Можно добавить несколько
* добавок, при условии, что они разные.
* 
* @param topping     Тип добавки
* @throws {HamburgerException}  При неправильном использовании
*/

Hamburger.prototype.addTopping = function (topping) {
  
  try{
    if(this.toppingArray.includes(topping)){
      // document.write(this.toppingArray.includes(topping))
      throw new HamburgerException(`You tried to add the same topping`);
    } else{
      this.toppingArray.push(topping);
     
    }
    
  }catch(e){
      console.log(`${e}`); 
    }
    
}

/**
 * Убрать добавку, при условии, что она ранее была 
 * добавлена.
 * 
 * @param topping   Тип добавки
 * @throws {HamburgerException}  При неправильном использовании
 */
Hamburger.prototype.removeTopping = function (topping) {
  try {
    if(this.toppingArray.length === 0){
      throw new HamburgerException('There is no any topping to delete');
    } else if(!this.toppingArray.includes(topping)){
      throw new HamburgerException(`There is no any topping like ${topping.name}`);
    } else {
      this.toppingArray = this.toppingArray.filter(element => element.name!=topping.name);
    }
    
  } catch (e) {
      console.log(`${e}`)
  }
}

/**
 * Получить список добавок.
 *
 * @return {Array} Массив добавленных добавок, содержит константы
 *                 Hamburger.TOPPING_*
 */
Hamburger.prototype.getToppings = function () {
  var topAr = []
  this.toppingArray.forEach(element => {topAr.push(element)});
  return topAr
}

/**
 * Узнать размер гамбургера
 */
Hamburger.prototype.getSize = function () {
  console.log(this.size.name)
}

        
/**
 * Узнать начинку гамбургера
 */
Hamburger.prototype.getStuffing = function () {
  console.log(this.stuffing.name)
}

/**
 * Узнать цену гамбургера
 * @return {Number} Цена в тугриках
 */
Hamburger.prototype.calculatePrice = function () {
  var totalPrice = 0;
  for (var value of Object.values(this)) {
    if(typeof value === 'object'&&!Array.isArray(value)){
      totalPrice +=value.price;
    } else if(Array.isArray(value)) {
      for(var i=0;i<this.toppingArray.length;i++){
        totalPrice += this.toppingArray[i].price;
      }
    } 
  }
  
  return totalPrice;
}

/**
 * Узнать калорийность
 * @return {Number} Калорийность в калориях
 */
Hamburger.prototype.calculateCalories = function () {
  var totalCalories = 0;
  for (var value of Object.values(this)) {
    if(typeof value === 'object'&&!Array.isArray(value)){
      totalCalories +=value.value;
    } else if(Array.isArray(value)) {
      for(var i=0;i<this.toppingArray.length;i++){
        totalCalories += this.toppingArray[i].value;
      }
    } 
  }
  
  return totalCalories;
}

function HamburgerException (message){
    Error.call(this.message)
    this.name = "We catch new mistake"

    this.message = message;
    this.mess = "Mistake in " + message;

  if(Error.captureSackTrace){
    Error.captureSackTrace(this.HamburgerException);
  } else{
    this.stack = (new Error()).stack;
  }
}
      
HamburgerException.prototype = Object.create(Error.prototype)    

        // маленький гамбургер с начинкой из сыра
        var hamburger = new Hamburger(Hamburger.SIZE_SMALL, Hamburger.STUFFING_CHEESE);
        // добавка из майонеза
        hamburger.addTopping(Hamburger.TOPPING_MAYO);
        // спросим сколько там калорий
        console.log("Calories: %f", hamburger.calculateCalories() );
        // сколько стоит
        console.log("Price: %f", hamburger.calculatePrice());
        // я тут передумал и решил добавить еще приправу
        hamburger.addTopping(Hamburger.TOPPING_SPICE);
        // А сколько теперь стоит? 
        console.log("Price with sauce: %f", hamburger.calculatePrice());
        // Проверить, большой ли гамбургер? 
        console.log("Is hamburger large: %s", hamburger.getSize() === Hamburger.SIZE_LARGE); // -> false
        // Убрать добавку
        hamburger.removeTopping(Hamburger.TOPPING_SPICE);
        console.log("Have %d toppings", hamburger.getToppings().length); // 1