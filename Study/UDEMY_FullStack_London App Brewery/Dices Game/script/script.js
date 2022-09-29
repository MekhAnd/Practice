document.addEventListener("click", ()=>window.location.reload())

function rotate() {
    return Math.floor(Math.random()*(5-0)+0);
}

var array = [];
array[0] = 'images/dice1.png'
array[1] = 'images/dice2.png'
array[2] = 'images/dice3.png'
array[3] = 'images/dice4.png'
array[4] = 'images/dice5.png'
array[5] = 'images/dice6.png'




var player1 = rotate();
var player2 = rotate();

console.log(player1, player2)


let res01 = document.querySelector("#field01");
res01.style.background = `url(${array[player1]})`;
// console.log(res01.style.background)
res01.style.backgroundPosition= "center";
res01.style.backgroundRepeat = "no-repeat";


let res02 = document.querySelector("#field02");
res02.style.backgroundImage = `url(${array[player2]})`;
// console.log(res02.style.background)
res02.style.backgroundPosition= "center";
res02.style.backgroundRepeat = "no-repeat";


if(player1>player2){
    document.querySelector('h1').textContent = "Player 1 win";
} else if (player1<player2){
    document.querySelector('h1').textContent = "Player 2 win";
} else{
    document.querySelector('h1').textContent = "DRAW";
}

