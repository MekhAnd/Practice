window.onload = ()=> {
    const timer = document.getElementById("timer");
    timer.style.width = "50%";
    timer.style.height = "150px";
    timer.style.margin = "0 auto";
    timer.style.display = "flex";
    timer.style.backgroundColor = "black";
    timer.style.color = "white";
    timer.style.fontSize = "8em";
    timer.style.justifyContent = "center";

    const buttons = document.getElementById("buttons");
    buttons.style.width = "50%";
    buttons.style.height = "50px";
    buttons.style.margin = "0 auto";
    buttons.style.display = "grid";
    buttons.style.gridTemplateColumns = "2fr 2fr 2fr";
    buttons.style.justifyContent = "center";

    const start = document.getElementById("startB");
    start.style.backgroundColor = "green";
    start.style.color = "white";
    start.style.fontSize = "3em";
    start.style.borderRadius = "10%";

    const stop = document.getElementById("pauseB");
    stop.style.backgroundColor = "red";
    stop.style.color = "white";
    stop.style.fontSize = "3em";
    stop.style.borderRadius = "10%";

    const clear = document.getElementById("clearB");
    clear.style.backgroundColor = "blue";
    clear.style.color = "white";
    clear.style.fontSize = "3em";
    clear.style.borderRadius = "10%";

    const min = document.getElementById("minutes");
    const sec = document.getElementById("seconds");
    const hour = document.getElementById("hours");
    min.innerHTML = "00";
    sec.innerHTML = "00";
    hour.innerHTML = "00";


    let secCounter = parseInt(0);
    let minCounter = 0;
    let hourCounter = 0;
    let interval;

    start.onclick=()=>{
        interval = setInterval(countSec, 1000);
    }

    stop.onclick =()=>{
        clearInterval(interval);
    }

    clear.onclick = ()=>{
        clearInterval(interval);
        secCounter = 0;
        minCounter = 0;
        hourCounter = 0;
        sec.innerHTML = `0${secCounter}`
        min.innerHTML = `0${minCounter}`
        hour.innerHTML = `0${hourCounter}`
    }

    const countSec = () =>{
        secCounter++;
        if(secCounter<10){
            sec.innerHTML = `0${secCounter}`;
        } else if (secCounter<60){
            sec.innerHTML = `${secCounter}`;
        } else if(secCounter===60){
            secCounter = 0;
            minCounter++;
            sec.innerHTML = `0${secCounter}`;
            if (minCounter<10){
                min.innerHTML = `0${minCounter}`
            } else if (minCounter<60){
                min.innerHTML = `${minCounter}`
            } else if (minCounter===60){
                minCounter=0;
                secCounter = 0;
                hourCounter++;
                hour.innerHTML = hourCounter;
            }
        }
    }
}