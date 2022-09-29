// 'use strict'
// Создайте функцию user, сделайте так чтобы функция выводила в консоль контекст 
function user() {
    return this;
  }

console.log (user());

/*Создайте обьект userOne, добавьте к нему свойства имя, фамилия, возраст и функцию, которая будет выводить " Привет! 
Я имя + фамилия " Выведите имя и фамилию пользователя с объекта userOne.*/
let userOne = {
        name:'Name',
        lastName : 'Lastname',
        greetings (){
                return `Привет! Я ${this.name} + ${this.lastName}!`;
        }
}
console.log(userOne.greetings())
console.log("!")

let fun = userOne.greetings;

// Сделайте так, чтобы контекст в методе объекта userOne был глобальный объект window.
console.log(fun.call(userOne));

// Создайте еще один объект userTwo и заполните его теми же свойствами, но без метода. 
let userTwo = {
    name:'Eman',
    lastName : 'Emantsal',
}

// Выведите информацию с объекта userTwo используя метод объекта userOne. 
console.log(fun.call(userTwo));