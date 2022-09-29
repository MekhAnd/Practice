let radius = 0;

const draw = () =>{
    //Видаляємо попередній контент
    const dis = document.getElementById('disappear');
    dis.remove();
    // Створюємо поле для діаметру кола та кнопку
    const input = document.createElement("input");
    input.style.cssText = 'height:20px; width:100px; id:radius; type:number;'
    input.value = 0;
    input.placeholder = 'Введіть радіус px';
    
    document.body.append(input);

    // Створюємо кнопку
    const button = document.createElement('button');
    button.style.cssText = "height:20px; width:100px; id:radius2; onclick:drw()"
    button.innerHTML = "Малюй вже!"
    
    document.body.append(button);

    const body = document.getElementById("main");
    body.style.display = "grid";
        
    // Ф-ція запускається DOM lvl0 (через кнопку)
    const drw = () =>{
        radius = parseInt(input.value);
        input.remove();
        button.remove();
        // ф-ція для зміни коліру
        let color = () => {
            let tmp = Math.ceil(Math.random()*255)
            return tmp;}
        //змінюємо властивості main (поле для блоків 10*10)
        main.style.cssText =  `height:${(radius*2)*10}px;
                                width:${(radius*2)*10}px;
                                margin:0 auto;
                                display:grid;
                                grid-template-columns: repeat(10,${radius*2}px); 
                                grid-template-rows: repeat(10,${radius*2}px);`
        // Створюємо перший блок 
        const newDiv = document.createElement("div");
        newDiv.style.height = `${radius*2}px`;
        newDiv.style.width =`${radius*2}px`;
        newDiv.style.backgroundColor = `rgb(255, 125, 65)`;
        newDiv.style.borderRadius = `50%`;
        newDiv.className = `div_dis`;
        main.append(newDiv);
  
        // циклом створюємо наступні при цьому генеруємо колір за допомогою ф-ції для кожного блоку
        for (let i = 0; i <=10; i++) {
           for (let j = 0; j<9; j++){ 
               let divL2 = newDiv.cloneNode();
               newDiv.after(divL2);
               divL2.style.backgroundColor = `rgb(${color()}, ${color()}, ${color()})`;
           }
        }

        // Прослуховуємо клік, видаляємо div
        let divL3 = document.getElementsByClassName("div_dis");

        for(let i = 0; i<divL3.length; i++){
            let element = divL3[i];
            element.addEventListener('click', function(e){
                element.remove();
            })
        }
        


       
        
        console.log("click!! +" + radius)
        
    }

    button.onclick = drw;

       
}

