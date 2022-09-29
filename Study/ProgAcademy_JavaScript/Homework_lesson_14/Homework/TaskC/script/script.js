// Сделайте функцию, которая считает и выводит количество своих вызовов. 


// Варіант 1
let couner0 = 0;

function count0 (){
    couner0++;
    console.log(couner0);
}

count0();
count0();
count0();
count0();
count0();

console.log('===================================');

//Варіант 2
function count1 (){
    let counter1 = 0 
    return function plus() {
        counter1+=1
        console.log(counter1)};
}

let draw = count1();

draw()
draw()
draw()
draw()
draw()

