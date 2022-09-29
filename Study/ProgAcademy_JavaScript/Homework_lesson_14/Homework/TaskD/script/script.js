/* Сделайте функцию, каждый вызов который будет генерировать случайные числа от 
1 до 100, но так, чтобы они не повторялись, пока не будут перебраны все числа 
из этого промежутка. Решите задачу через замыкания - в замыкании должен хранится 
массив чисел, которые уже были сгенерированы функцией. */

function arrayCreator (){
    let mainArray = new Array();
    // Створюємо ф-цію для генерації числа
    function randomNumber(){
        let tmp = Math.ceil(Math.random()*100);
        return tmp
    }
   // Ф-ція для заповнення
    return function fill (){
        let tmp= randomNumber(); //запитуємо згенероване число
        if (!mainArray.includes(tmp)){ //перевіряємо
            mainArray.push(tmp);  //якщо ок => записуємо в масив
        } else if(mainArray.length === 100){
            return "Більше не має варінтів"
        } else {    //не пройшли перевірку => викликаємо знову
            fill()
        }
        console.log('mainArray',mainArray)
    }
        
    
}

let firstGame = arrayCreator();

firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
firstGame();
