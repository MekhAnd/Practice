const createNewDiv = () =>{
    const main = document.getElementById("element");
    const div = document.createElement("div");
    
    let num = document.getElementsByClassName("newDiv");
    div.className = "newDiv";

    div.innerHTML = `That is my new div # ${num.length+1}`;
    main.insertBefore(div, main.firstChild);
    
    if (checker()) {
        main.insertBefore(div, main.firstChild); 
        num++;   
    } else {
        divRemove();
    }
}

const divRemove =()=>{
    const counter = document.getElementsByClassName("newDiv");
    Array.from(counter).forEach(element => element.remove());
}

const checker = () =>{
    let checker = false;
    const counter = document.getElementsByClassName("newDiv");
    if (counter.length<=10){
        checker = true;
    } else {
        checker = false;
    }
    return checker;
}