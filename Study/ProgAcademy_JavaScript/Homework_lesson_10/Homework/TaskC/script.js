window.addEventListener("DOMContentLoaded", (e)=>{
    // Створюємо глобальні змінні
    let mineArray = new Array();
    let battleField = new Array();
    let fullField = new Array();
    let rows = 0;
    let columns = 0;
    let mineQ = 0;
    let mineFlags = 0;


    /* Слухаємо: 
    -у випадку кнопки - запускаємо підготовку поля
    -у випадку якщо поле побудоване -ловим поле
    */ 
    const start = document.addEventListener( 'click', function(e){
        if(e.target.id === 'start'){
            preparing();
        } else if (e.target.className.includes("play")){
            press(e)
        }
    })
    //  Готуємо мінне поле (к-ть рядів, колонок, мін)
    
        const preparing = ()=>{
        const data = document.getElementById('data');
        rows = +(data.value);
        columns = rows;
        mineQ = Math.ceil((rows*columns)/6);
        console.log(mineQ)
        mineArray = minePlace();
        battleField = buildField(mineArray);
        fullField = placeNumbers(battleField);
        drawField();       
    }
    //Розраховуємо місця для мін
    const minePlace = ()=>{
        let minePlace = new Array();
        for (let i = 0; i < mineQ; i++) {
            let place = (Math.ceil(Math.random()*(rows*columns-1)));
            while(minePlace.includes(place)){
                place = (Math.ceil(Math.random()*(rows*columns-1)));
            }
            console.log(`place ${place}`)
            minePlace.push(place);
        }
        return minePlace.sort(function(a,b){
            return a-b;
        });
    }
    //Розташовуємо міни по місцях - міна 9 (у одного поля тільки 8 сусідів)
    const buildField = (array0)=>{
        let field = 0;
            
        for (let i = 0; i<rows; i++){
            for(let k = 0; k<columns; k++ ){
            if(array0.includes(field)){
                    fullField.push(9);
                }else{
                    fullField.push(0);
                }
                field++;
            }
        
        }
            return fullField;
    }
   //Розраховуємо сусідні поля та розставляємо їх значення (0-пусте поле)
    const placeNumbers = (a) =>{
    let array = a;

    let field = 0;
    for (let i = 0; i<rows; i++){
        for(let k = 0; k<columns; k++ ){
            let newNumber = 0;
            if(array[field]===9){
                if(i === 0){
                    if(k === 0){
                        //ПЕРЕВІРЕНО
                        array[field+1] = (array[field+1]!=9) ? (array[field+1]+=1) : 9;
                        // console.log(`З поля ${field} Перехід до поля ${field+1}`)
                        array[field+(rows)] = (array[field+(rows)]!=9) ? (array[field+(rows)]+=1) : 9;
                        array[field+(rows+1)] = (array[field+(rows+1)]!=9) ? (array[field+(rows+1)]+=1) : 9;
                    }else if(k>0 && k < rows-1){
                        //ПЕРЕВІРЕНО
                        array[field-1] = (array[field-1]!=9) ? (array[field-1]+=1) : 9;
                        array[field+1] = (array[field+1]!=9) ? (array[field+1]+=1) : 9;
                        array[field+(rows-1)] = (array[field+(rows-1)]!=9) ? (array[field+(rows-1)]+=1) : 9;
                        array[field+(rows)] = (array[field+(rows)]!=9) ? (array[field+(rows)]+=1) : 9;
                        array[field+(rows+1)] = (array[field+(rows+1)]!=9) ? (array[field+(rows+1)]+=1) : 9;
                    }else if(k===(rows-1)){
                        array[field-1] = (array[field-1]!=9) ? (array[field-1]+=1) : 9;
                        array[field+(rows)] = (array[field+(rows)]!=9) ? (array[field+(rows)]+=1) : 9;
                        array[field+(rows-1)] = (array[field+(rows-1)]!=9) ? (array[field+(rows-1)]+=1) : 9;
                    }
                }else if(i>0 && i< rows-1){
                    if(k === 0){
                        array[field-(rows)] = (array[field-(rows)]!=9) ? (array[field-(rows)]+=1) : 9;
                        array[field-(rows-1)] = (array[field-(rows-1)]!=9) ? (array[field-(rows-1)]+=1) : 9;
                        array[field+1] = (array[field+1]!=9) ? (array[field+1]+=1) : 9;
                        array[field+(rows)] = (array[field+(rows)]!=9) ? (array[field+(rows)]+=1) : 9;
                        array[field+(rows+1)] = (array[field+(rows+1)]!=9) ? (array[field+(rows+1)]+=1) : 9;
                    }else if(k>0 && k < rows-1){
                        array[field-(rows+1)] = (array[field-(rows+1)]!=9) ? (array[field-(rows+1)]+=1) : 9;
                        array[field-(rows)] = (array[field-(rows)]!=9) ? (array[field-(rows)]+=1) : 9;
                        array[field-(rows-1)] = (array[field-(rows-1)]!=9) ? (array[field-(rows-1)]+=1) : 9;
                        array[field-1] = (array[field-1]!=9) ? (array[field-1]+=1) : 9;
                        array[field+1] = (array[field+1]!=9) ? (array[field+1]+=1) : 9;
                        array[field+(rows-1)] = (array[field+(rows-1)]!=9) ? (array[field+(rows-1)]+=1) : 9;
                        array[field+(rows)] = (array[field+(rows)]!=9) ? (array[field+(rows)]+=1) : 9;
                        array[field+(rows+1)] = (array[field+(rows+1)]!=9) ? (array[field+(rows+1)]+=1) : 9;
                    }else if(k===(rows-1)){

                        array[field-(rows+1)] = (array[field-(rows+1)]!=9) ? (array[field-(rows+1)]+=1) : 9;
                        array[field-(rows)] = (array[field-(rows)]!=9) ? (array[field-(rows)]+=1) : 9;
                        array[field-1] = (array[field-1]!=9) ? (array[field-1]+=1) : 9;
                        array[field+(rows)] = (array[field+(rows)]!=9) ? (array[field+(rows)]+=1) : 9;
                        array[field+(rows-1)] = (array[field+(rows-1)]!=9) ? (array[field+(rows-1)]+=1) : 9;
                    }
                } else if(i === (rows-1)){
                    if(k === 0){
                        array[field-(rows)] = (array[field-(rows)]!=9) ? (array[field-(rows)]+=1) : 9;
                        array[field-(rows-1)] = (array[field-(rows-1)]!=9) ? (array[field-(rows-1)]+=1) : 9;
                        array[field+1] = (array[field+1]!=9) ? (array[field+1]+=1) : 9;
                    }else if(k>0 && k < rows-1){
                        array[field-(rows+1)] = (array[field-(rows+1)]!=9) ? (array[field-(rows+1)]+=1) : 9;
                        array[field-(rows)] = (array[field-(rows)]!=9) ? (array[field-(rows)]+=1) : 9;
                        array[field-(rows-1)] = (array[field-(rows-1)]!=9) ? (array[field-(rows-1)]+=1) : 9;
                        array[field-1] = (array[field-1]!=9) ? (array[field-1]+=1) : 9;
                        array[field+1] = (array[field+1]!=9) ? (array[field+1]+=1) : 9;
                    }else if(k===(rows-1)){
                        array[field-(rows+1)] = (array[field-(rows+1)]!=9) ? (array[field-(rows+1)]+=1) : 9;
                        array[field-(rows)] = (array[field-(rows)]!=9) ? (array[field-(rows)]+=1) : 9;
                        array[field-1] = (array[field-1]!=9) ? (array[field-1]+=1) : 9;
                    }
                }
            }
            field++;
        }
    }
        console.log(array);
        return array;
    }

    //скидаємо всі показники - нова гра
    const clear =()=> {
        document.getElementById('field').remove();
        mineArray = new Array();
        battleField = new Array();
        fullField = new Array();
        rows = 0;
        columns = 0;
        mineQ = 0;
        mineFlags = 0;
        document.getElementById('text').remove();
        preparing();
    }

    //промальовуємо початкове поле 
    const drawField = ()=>{
                
        if (document.getElementById('field')!=null){
            clear();
        } else {

            let main = document.getElementById('main');
            
            let mainField = document.createElement("div");
            mainField.style.cssText = `height:${rows*50}px; 
                                    width:${columns*50}px; 
                                    border: 1px solid #8ca3a3; 
                                    display:grid; grid; 
                                    grid-template-columns: repeat(${columns}, 50px); 
                                    grid-template-columns: repeat(${rows}, 50px); 
                                    background-color: #1A3C40; `;
            mainField.id = 'field';
        
            
            main.append(mainField);
            newDiv = document.createElement('div');
            newDiv.className = `${fullField[rows*columns-1]} play`;
            newDiv.id = rows*columns-1;
            
            newDiv.style.cssText = `border: 1px solid #8ca3a3;
                                    font-size:0.5em; color:red;
                                    text-align: center;`
            mainField.append(newDiv);

            for(let i = 0; i<fullField.length-1; i++){
                let div = newDiv.cloneNode();
                newDiv.before(div);
                div.className = `${fullField[i]} play`;
                div.id = i;
                div.style.cssText = `border: 1px solid #8ca3a3; 
                                    font-size:0.5em;
                                    color:red;
                                    text-align: center;`
            }
        }
    }

    // Промальовка пустих полів (якщо має клас 0 - розраховуємо та відкриваємо пусті поля)
    let div = (e)=>{ 
        let current0Field = parseInt(e);
        let change0 = document.querySelectorAll('div.play');
        

        change0[current0Field].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/grass.png');
                                                background-position:center
                                                background-size:fill`;
        //для поля з класом 0 - встановлюємо додатковий клас (перевірено)
        change0[current0Field].className += " checked";

        let row = Math.floor(current0Field/rows);
        let col = current0Field-(rows*row);
        
        
        if(row === 0){
            if(col === 0){
                change0[current0Field+1] = (change0[current0Field+1].className==="checked")? change0[current0Field+1].className+= " !":drawing(change0[current0Field+1].id);
                change0[current0Field+(rows)].id = (change0[current0Field+(rows)].className==="checked")? change0[current0Field+(rows)].className+= " !":drawing(change0[current0Field+(rows)].id);
                change0[current0Field+(rows+1)].id = (change0[current0Field+(rows+1)].className === "checked")? change0[current0Field+(rows+1)].className += " !":drawing(change0[current0Field+(rows+1)].id);
            }else if(col>0 && col < rows-1){
                drawing(change0[current0Field-1].id);
                drawing(change0[current0Field+1].id);
                drawing(change0[current0Field+(rows-1)].id);
                drawing(change0[current0Field+(rows)].id);
                drawing(change0[current0Field+(rows+1)].id)
            }else if(col===(rows-1)){
                drawing(change0[current0Field-1].id);
                drawing(change0[current0Field+(rows)].id);
                drawing(change0[current0Field+(rows-1)].id)
            }
        }else if((row>0 && row< rows-1)){
            if(col === 0){
                drawing(change0[current0Field-(rows)].id);
                drawing(change0[current0Field-(rows-1)].id);
                drawing(change0[current0Field+1].id);
                drawing(change0[current0Field+(rows)].id);
                drawing(change0[current0Field+(rows+1)].id)
            }else if(col>0 && col < rows-1){
                drawing(change0[current0Field-(rows+1)].id)
                drawing(change0[current0Field-(rows)].id);
                drawing(change0[current0Field-(rows-1)].id)
                drawing(change0[current0Field-1].id);
                drawing(change0[current0Field+1].id);
                drawing(change0[current0Field+(rows)].id);
                drawing(change0[current0Field+(rows-1)].id)
                drawing(change0[current0Field+1].id);
            }else if(col===(rows-1)){

                drawing(change0[current0Field-(rows+1)].id)
                drawing(change0[current0Field-(rows)].id);
                drawing(change0[current0Field-1].id);
                drawing(change0[current0Field+(rows)].id);
                drawing(change0[current0Field+(rows-1)].id)
            }
        } else if(row === (rows-1)){
            if(col === 0){
                drawing(change0[current0Field-(rows)].id);
                drawing(change0[current0Field+(rows-1)].id)
                drawing(change0[current0Field+1].id);
            }else if(col>0 && col < rows-1){
                drawing(change0[current0Field-(rows+1)].id)
                drawing(change0[current0Field-(rows)].id);
                drawing(change0[current0Field-(rows-1)].id)
                drawing(change0[current0Field-1].id);
                drawing(change0[current0Field+1].id);
            }else if(col===(rows-1)){
                drawing(change0[current0Field-(rows+1)].id)
                drawing(change0[current0Field-(rows)].id);
                drawing(change0[current0Field-1].id);
            }
        }
    }

    // Зчитуємо id div (передаємо його в промальовку), та прописуємо к-ть мін
    const press = (e)=>{
        // let tmp = parseInt(e.originalTarget.className);
        let coor = parseInt(e.originalTarget.id);
        document.getElementById('start').innerHTML = "Почати нову гру";
        
        let text = document.getElementById('left');
        let txt =  document.querySelector('#text');
        

        if(txt===null){
            let textDiv = document.createElement('div');
            textDiv.className = `text_content`;
            textDiv.id= `text`;
            textDiv.innerHTML = `Всього мін ${mineQ} / Знайдено ${mineFlags}`;
            text.append(textDiv);
            console.log(mineFlags)
        } else {
            console.log(mineFlags)
            textDiv0=document.querySelector('#text'); 
            textDiv0.innerHTML = `Всього мін ${mineQ} / Знайдено ${mineFlags}`;
        }

        drawing(coor);
    }

    /*приймаємо id, читаємо його клас, промальовуємо, якщо 0 
    (і не має классу перевірено) тоді викликаємо div()*/
    const drawing = (coor) =>{ 
        
        coor = parseInt(coor);
        let move = document.querySelectorAll('div.play');
        let fieldClass = parseInt(move[coor].className);
        
        if(fieldClass === 0){
            if(!(move[coor].className).includes("checked")){
                div(coor);
            }
        } else {
            switch (fieldClass) {
                case 1:
                    move[coor].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/_s.png');
                                                background-position:6% 15%;`
                    move[coor].className += " checked";                            
                    break;
                case 2:
                    move[coor].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/_s.png');
                                                background-position:28% 15%;`
                    move[coor].className += " checked";
                    break;
                case 3:
                    move[coor].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/_s.png');
                                                background-position:50% 15%;`
                    move[coor].className += " checked";
                    break;
                case 4:
                    move[coor].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/_s.png');
                                                background-position:72% 15%;`
                    move[coor].className += " checked";
                    break;
                case 5:
                    move[coor].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/_s.png');
                                                background-position:93% 15%;`
                    move[coor].className += " checked";
                    break;
                case 6:
                    move[coor].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/_s.png');
                                                background-position:4% 83%;`
                    move[coor].className += " checked";
                    break;

                case 7:
                    move[coor].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/_s.png');
                                                background-position:27% 82%;`
                    move[coor].className += " checked";
                    break;
                case 8:
                    move[coor].style.cssText = `background-color:#8ca3a3;
                                                background-image: url('../TaskC/_s.png');
                                                background-position:50% 83%;`
                    move[coor].className += " checked";
                    break;
                case 9:
                    boom(coor)
                    break;
                
                default:
                    break;
            }
        }

        // Перевіряємо - якщо win = true то підіймаємо модальне вікно
        if(win()){
            let changeWin = document.getElementById('modal_wind');
            changeWin.style.display="block";

            let ok = document.addEventListener('click', function(e){
                if(e.target.id === "ok"){
                    changeWin.style.display="none";
                    clear();
                }
            })
        }
    }
    

    /*Якщо спіймали класс 9 (боНба)*/
    const boom = (coor) =>{
        let change9 = document.querySelectorAll('div.play');
        
        
        for(let i = 0; i<change9.length; i++ ){
            if (change9[i].className.includes("9")){
                
                change9[i].style.cssText = `font-size:1.5em;
                                            color:red;
                                            text-align: center;
                                            background-color:red;
                                            background-image: url('../TaskC/mine2.png');
                                            background-position:center;`
            } else{
                change9[i].style.cssText += `pointer-events: none;`
                continue;
            }
        }



    }

    /**Слухаємо правий клік -= додаємо або прибираємо флаг (в класі теж), а також к-ть мін */
    const flag = document.addEventListener('contextmenu', function(e){
        
        if((e.target.className).includes('flag')){
            e.target.style.backgroundImage = '';
            let tmpClass = e.target.className;
            e.originalTarget.className = tmpClass.replace(new RegExp(' flag','g'), "");
            mineFlags --;
            
        } else {
            e.target.style.cssText = `background-image: url('../TaskC/flag_s.png');
                                  background-position:center;
                                  background-repeat: no-repeat;`
            e.target.className += " flag";
            mineFlags++;
        }

    })

    //Рахуємо кількість флагів і кількість перевірених полів,
    //якщо співпадає -то передаєм true (піднімає модальне вікно)
    const win = () =>{
        let move = document.querySelectorAll('div.play');
        let chck0 = 0;
        let chck1 = 0;
        for(let i = 0; i<move.length; i++ ){
            if(move[i].className.includes('flag')
                && move[i].className.includes('9')){
                chck0++;
            }
            if(move[i].className.includes('checked')){
                chck1++;
            }
        }

        
        if ((chck0===mineQ)&&(chck1===((rows*rows) - mineQ))){
            return true;
        } else{
            return false;
        }
    }
    
})
//Відключаємо контекстне меню (спер)
window.oncontextmenu = function(event) {
    event.preventDefault();
    event.stopPropagation();
    return false;
};