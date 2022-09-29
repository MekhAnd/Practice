window.onload = ()=>{
    const block = document.getElementById("container");

    block.style.width = "100%";
    block.style.height = "250px";
    block.style.display = "grid";
    block.style.gridTemplateColumns = "2fr 2fr";
    block.style.justifyContent = "center";
    block.style.backgroundColor = "#CCCCFF";

    const left = document.getElementById("left");

    left.style.width = "100%";
    left.style.height = "250px";
    left.style.display = "grid";
    left.style.gridTemplateRows = "2fr 2fr";
    block.style.justifyContent = "center";
    block.style.backgroundColor = "#ACCCFF";

    const leftTop = document.getElementById("left_top");

    leftTop.style.display = "flex";
    leftTop.style.flexDirection = "row"
   
    const butt = document.getElementById("subm");
    
    butt.style.width = "35%"
    butt.style.color= "black";
    butt.style.fontSize = "2em"
    butt.style.marginLeft = "25px"

    const field = document.getElementById("inp");
    
    field.style.backgroundColor = "black";
    field.style.width= "60%";
    field.style.height= "125px";
    field.style.color = "white"
    field.style.fontSize = "8em";
    field.style.textAlign = "center";

    const mess = document.getElementById("message");

    mess.style.backgroundColor = "black";
    mess.style.color = "white"
    mess.style.fontSize = "1.5em"

    const inf = document.getElementById("info");
    
    const number = Math.ceil(Math.random()*100);
    mess.innerHTML = `Я задумав число! Коли будеш готовий - внеси число та тисни ПОЇХАЛИ`;    

    butt.onclick = () =>{
        let tmp = document.getElementsByTagName("input")[0].value;
        if (tmp>number) {
            inf.style.backgroundColor = `rgb(245, 0, 0)`;
            mess.innerHTML = "УУУУУУУУУ... Моє число Меньше :)";
            mess.style.textAlign = "center";
            mess.style.justifyContent = "center";
            } else if (tmp<number) {
            inf.style.backgroundColor = `rgb(0, 0, 245)`;
            mess.innerHTML = "АААААААААААААААААА... Моє число Більше ;)";
            mess.style.textAlign = "center";
            mess.style.justifyContent = "center";
        } else{
            inf.style.backgroundColor = `rgb(0, 245, 0)`;
            mess.innerHTML = "ОГО... Вгадав ";
            mess.style.textAlign = "center";
            mess.style.justifyContent = "center";
        }


    }
}