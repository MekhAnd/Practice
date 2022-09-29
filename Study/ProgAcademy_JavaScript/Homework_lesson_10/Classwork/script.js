// debugger
window.addEventListener('load', (e)=>{


    //визначаємо змінні які спостерігають за групами кнопок калькулятора
    let digits = document.querySelectorAll("button.button_digit__row, button.button_digit__row_"  );
    let signal = document.querySelectorAll("button.button_first__sign");
    let service = document.querySelectorAll("button.button_first__row");
    // та клавіатурою
    let keys = document.addEventListener('keyup', function(e){
        
        //якщо отримуємо сигнал з Numpad або Digits - відправляємо до ф-цій
        //display - відображення, fбо sign - знаки (математичні операції)
        if(((e.code).includes('Numpad')||(e.code).includes('Digit'))&&!(e.code).includes('Enter') ){
           if((e.key)>=0){
               displayKey(parseFloat(e.key));
            } else {
                operations(e.key);
            }
            
        } else{
            // алe якщо бачим Esc або Enter
            if(e.keyCode===27){ //знаю, що застаріла, але e.key та e.code чомусь не спіймали
                clear();
            }else {
                operations("=");
            }

            
            return;
        }
        
    });
    
    //змінна для дісплея
    let monitor = document.getElementById("monitor");
    

    //глобальні змінні
    let sign = 'e';
    let number0 = 'a';
    let number1 = 'b';
        
    
    //для опрацювання повідомлень від кнопок запускаємо цикли
    for (let i = 0; i < digits.length; i++) {
        let num = digits[i];
        num.addEventListener("click", function(e){
            //визначаємо яка сама кнопка задіяна та передаємо інф у відповідну ф-цію
            display(e);
        })
    }

    //для знаків - фунція переходу в мат.операції
    for (let i = 0; i < signal.length; i++) {
        let sig = signal[i];
        sig.addEventListener("click", function(e){
        operations(e);
        })
    }
    
    //сервісні кнопки = зміна знака, %, скидання
    for (let i = 0; i < service.length; i++) {
        
        let serv = service[i];
        serv.addEventListener("click", function(e){
            console.log(e.target.value)
            if(e.target.value === "c"){
                clear();
            } else if(e.target.value === "%") {
                operations(e)
            } else{
                minus();
            }
        })
    }
    
    //відображення на моніторі для клавіатури
    const displayKey = (e) => {
        if(monitor.value === '0'|| monitor.value === String(number0)){
            monitor.value = e;
        } else {
            monitor.value += e;
        }
    }
    
    //відображення чисел на моніторі
    const display = (e) => {
       if(monitor.value === '0'|| monitor.value === String(number0)){
                monitor.value = e.target.value;
            } else {
                monitor.value += e.target.value;
            }
        }

    //службова ф-ція для зберігання
    const save = (value)=>{
        let tmp = monitor.value
        
        return tmp;
    }

    //ф-ція для запису чисел та передачі в математичну частину (перша частина головного болю :))
    const operations = (e) =>{
        console.log(e + " OPERATIONS")
        //якщо перше число відсутнє - записуємо його і запам'ятовуємо знак
        if (number0 === 'a'){  
            number0= parseFloat(save(monitor.value));
            console.log(number0 + " = number0 " + monitor.value + " " + sign) 
            console.log(String(number0) === monitor.value)
            
            try {
                sign = e.target.value;
            } catch (error) {
                sign = e;
            }
            
            
        //для запису другого числа та наступного знаку
        } else if (number0 !== 'a'){
            number1 = parseFloat(save(monitor.value));
            // console.log(number1 + " = number1 " + monitor.value + " " + sign)
            // console.log(number0 + " = number0 " + monitor.value + " " + sign)
            console.log(sign, e)
            result(sign, e);

        } 
        
    }
    // матетматичні операції, відображення результату та передача наступного знаку
    const result = (e, a) =>{
        if (e==="%") {
            console.log("%")
            number0 = number0 * (number1/100);
            // number0 = parseInt(save(monitor.value));
        } else if (e==="/"){
            console.log("Ділення")
            number0= number0 / number1;
            // number0 = parseInt(save(monitor.value));
        } else if (e==="*"){
            console.log("Множення")
            number0= number0 * number1;
            // number0 = parseInt(save(monitor.value));
        }  else if (e==="-"){
            number0= number0 - number1;
            // number0 = parseInt(save(monitor.value));
        }  else if (e==="+"){
            number0 = number0 + number1; 
        }  
        //  else if (e.target.value==="="){
            monitor.value = number0;
        // }

        
        try {
            sign = a.target.value;    
        } catch (error) {
            sign = a;
        }
        
        console.log("Тепер number0 = " + number0 + sign)
    }

    //ф-ція зміни знаку
    const minus = () => {
        number0= parseFloat(save(monitor.value));
        number0 = number0 *(-1);
        monitor.value = number0;
    }

    //ф-ція очищення екрану
    const clear = () =>{
        monitor.value = 0;
        number0 = 'a';
        number1 = 'b';
        sign = 'e'
    } 
    
})