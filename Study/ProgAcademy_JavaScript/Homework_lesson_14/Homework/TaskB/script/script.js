// Создайте метод который будет умножать элементы массива на то число которое будет передавать пользователь.
// Сделайте так, чтобы метод наследовался каждым массивом подобно методу pop(). 


//Сподіваюсь що вірно зрозумів задачу
class ArrayVer extends Array {
        constructor(...set){
            super (...set);
            // this.name = name;
        }
        push(num){
            if(num.typeof === 'number'){
                super.push(num);
            }
        }
        calculateAr (number){
            this.forEach(function(element, i, array){
                array[i] = (element*number);
            })
            return this;
            
        }
}

let first = new ArrayVer(2, 4, 6, 8); 

console.log(first.calculateAr(2));

let second = new ArrayVer(4, 4, 4, 4); 

console.log(second.calculateAr(10));


//У випадку якщо ні то такий варіант
Array.prototype.calculate = function(num){
    const newArr = this.map((element, i, array)=>{
        return element * num});
    
    return newArr;
}

let third = [1,2,3,4,6];
console.log(third.calculate(6));
