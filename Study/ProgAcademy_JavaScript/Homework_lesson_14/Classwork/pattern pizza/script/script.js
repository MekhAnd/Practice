window.addEventListener("DOMContentLoaded", (e)=>{
   class Order {
        constructor(price, size, sauce, topping) {
            this.price = price;
            this.size = size;
            this.sauce = sauce;
            this.topping = topping;
        }
    } 
    class User {
        constructor (userName, phone, email){
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        }
    }

    const newOrder = new Order();
    const customer = new User();
   
   
    //Змінні для відображення складових
    var price = 0,
        sauce = '',
        topping = '';
  
    //Waiting for a mouse click
    const item = document.addEventListener('click', function (e){
        // console.log(e)
        // To define the Class Name of Item where User click and add price
        if(e.target.className.includes('radioIn')){
            newOrder.size = e.target.id;
            if(e.target.id==='small'){
                //if price variable is empty
                if(price === 0){ 
                    price = parseFloat(e.target.className.replace(/\D+/g,""));
                    let pricePlace = document.getElementsByClassName('price');
                    pricePlace[0].innerHTML = `<p>Цiна: ${price} грн</p>`;
                //in other case
                }else {
                    price += parseFloat(e.target.className.replace(/\D+/g,""));
                    let pricePlace = document.getElementsByClassName('price');
                    pricePlace[0].innerHTML = `<p>Цiна: ${price} грн</p>`;
                }
                
            } else if(e.target.id==='mid'){
                if(price === 0){
                    price=parseFloat(e.target.className.replace(/\D+/g,""));
                    let pricePlace = document.getElementsByClassName('price');
                    pricePlace[0].innerHTML = `<p>Цiна: ${price} грн</p>`;
                }else{
                    price+=parseFloat(e.target.className.replace(/\D+/g,""));
                    let pricePlace = document.getElementsByClassName('price');
                    pricePlace[0].innerHTML = `<p>Цiна: ${price} грн</p>`;
                }
                
            } else {
                if(price===0){
                    price=parseFloat(e.target.className.replace(/\D+/g,""));
                    let pricePlace = document.getElementsByClassName('price');
                    pricePlace[0].innerHTML = `<p>Цiна: ${price} грн</p>`;
                }else{
                    price+=parseFloat(e.target.className.replace(/\D+/g,""));
                    let pricePlace = document.getElementsByClassName('price');
                    pricePlace[0].innerHTML = `<p>Цiна: ${price} грн</p>`;
                }
                
            }
        } else{
            return;
        }
       
    })

    //Waiting for click the mouse button in the ingredient zone
    const ingridients =  document.addEventListener('mousedown', function (e){
        

        //if Class Name includes "draggable" sign
        if(e.target.className.includes('draggable')){
           
        //Change the price variable
           price+=parseFloat(e.target.className.replace(/\D+/g,""));
           let pricePlace = document.getElementsByClassName('price');
               pricePlace[0].innerHTML = `<p>Цiна: ${price} грн</p>`;
            
            //The same procedure for add Sauces and Toppings to there fields
            if(e.target.id.includes('sauce')){
                
                let saucePlace = document.getElementsByClassName('sauces');
                newOrder.sauce = '';
                switch (e.target.id) {
                    case 'sauceClassic':
                        sauce += 'Кетчуп '
                        saucePlace[0].innerHTML = `<p>Соуси: ${sauce}</p>`;
                        newOrder.sauce += sauce;
                        break;
                    case 'sauceBBQ':
                        sauce += 'BBQ '
                        saucePlace[0].innerHTML = `<p>Соуси: ${sauce}</p>`;
                        newOrder.sauce += sauce;
                        break;
                    case 'sauceRikotta':
                        sauce += 'Рікотта '
                        saucePlace[0].innerHTML = `<p>Соуси: ${sauce}</p>`;
                        newOrder.sauce += sauce;
                        break;
                    default:
                        break;
                }
            } else{
                let toppingPlace = document.getElementsByClassName('topings');
                newOrder.topping = '';
                switch (e.target.id) {
                    case 'moc1':
                        topping += 'Сир '
                        toppingPlace[0].innerHTML = `<p>Топiнги: ${topping}</p>`;
                        newOrder.topping += topping;
                        break;
                    case 'moc2':
                        topping += 'Фєта '
                        toppingPlace[0].innerHTML = `<p>Топiнги: ${topping}</p>`;
                        newOrder.topping += topping;
                        break;
                    case 'moc3':
                        topping += 'Моцарелла '
                        toppingPlace[0].innerHTML = `<p>Топiнги: ${topping}</p>`;
                        newOrder.topping += topping;
                        break;
                    case 'telya':
                        topping += 'Телятина '
                        toppingPlace[0].innerHTML = `<p>Топiнги: ${topping}</p>`;
                        newOrder.topping += topping;
                        break;
                    case 'vetch1':
                        topping += 'Томати '
                        toppingPlace[0].innerHTML = `<p>Топiнги: ${topping}</p>`;
                        newOrder.topping += topping;
                        break;
                    case 'vetch2':
                        topping += 'Гриби '
                        toppingPlace[0].innerHTML = `<p>Топiнги: ${topping}</p>`;
                        newOrder.topping += topping;
                        break;
                    default:
                        break;
                }
            }
            drag(e);
        }
        newOrder.price = price
        
    })
    // Waiting for mouse (cursor) placement to change the place of discount button
    const btn = document.querySelector('button.banner');
        btn.addEventListener('mousemove',(e)=>{
           
            btn.style.position = 'relative'
            btn.style.top = `${Math.floor(Math.random()*100)}px`;
            btn.style.left = `${Math.floor(Math.random()*100)}px`;
        })
    
    //Перетаскування інгрідієнтів на піцу
    function drag (e){
        
        // Визначаємо інгрідієнт
        let selectedItem = document.getElementById(`${e.target.id}`)

        // Змінюємо позиціонування та рівень в його css властивостях 
        selectedItem.style.position = 'absolute';
        selectedItem.style.zIndex = 100;

        //знаходимо позицію КУДА переміщуються інгрідієнти
        let plate = document.querySelector('.table');
        let table = document.querySelector('.table-wrapper');
        
        //додаємо інгрідіент в вузел
        plate.appendChild(selectedItem)

        //промальовка переміщення (зміна позиціонування об'єкта за координатами)
        moveAt(e.pageX, e.pageY);
        
        function moveAt(pageX, pageY) {
            selectedItem.style.left = pageX - selectedItem.offsetWidth + 'px';
            selectedItem.style.top = pageY - selectedItem.offsetHeight + 'px';
        }
        
        //прив'язуємо промальовку руху до руху мишею
        function onMouseMove(event) {
            moveAt(event.pageX, event.pageY);
        }

        //слухаємо рух - викликаємо відповідно ф-цію промальовка
        document.addEventListener('mousemove', onMouseMove);

        // відв'язуємо об'єкти та глушимо "слухач", коли юзер відпускає кнопку
        document.onmouseup = function() {
            document.removeEventListener('mousemove', onMouseMove);
            selectedItem.onmouseup = selectedItem.onmousemove = null;
          };

        //!!!Не розумію сенсу, але без цього не працює!!!  В Теорії - подія яка запускається при старті перетаскування,
        // тому якщо повертає false => мало б відключати перетаскування... Але ні...
        selectedItem.ondragstart = function() {
            return false;
        };
       
    }

    //Група чекерів для валідації полів форми
    const chckName = (e) =>{
        let pattern = /[\p{Alpha}]/gui;
        if(e.search(pattern)!=-1){
            customer.userName = e;
            return true;
        } else {
            return false;
        }
    }

    const chckPhone = (e) =>{
        let pattern = /\+380\d{9}/g;
        if(e.search(pattern)!=-1){
            customer.phone = e;
            return true;
        } else {
           return false;
        }
    }

    const chckEmail = (e) =>{
        let pattern = /^[\w-\.]+@[\w-]+.[a-z]{2,3}$/i;
        if(e.search(pattern)!=-1){
            customer.email = e;
            return true;
        } else {
            console.log('He Ok')
            return false;
        }
    }

    //Змінні для чекерів
    let chckN = false;
    let chckP = false;
    let chckE = false;


    // Вибір чекера для кожно поля, заповнення конструктора User
    const checker = (e)=>{
        if(e.target.name === 'name'){
            if(chckName(e.target.value)){
                chckN = true;
                e.target.style.background = 'white';
            } else {
                console.log(e)
                e.target.style.background = 'red';
                e.target.value = 'Введіть ім\'я';
                console.log('He Ok - first')
            }
        } else if(e.target.name === 'phone'){
           if(chckPhone(e.target.value)){
                chckP = true;
                e.target.style.background = 'white';
            } else {
                e.target.style.background = 'red';
                e.target.value = 'Введіть номер тел.';
            }
        } else if (e.target.name === 'email'){
            if(chckEmail(e.target.value)){
                chckE = true;
                e.target.style.background = 'white';
            }
            else {
                e.target.style.background = 'red';
                e.target.value = 'Введіть e-mail';
            }
        }
    }
    
    // Слухаємо зміни в поллях вооду
    const dataVal = document.addEventListener('change', (e)=>{
        checker(e)

    })

    // Шукаємо кнопку Submit
    const btnMail = document.getElementsByName('btnSubmit');
    let statusChck = false;
    //Чипляємо форму для відправки листа
    //Але відкрити відразу 2 вікна не вийшло = відкривається або лист, або thank-you...
    btnMail[0].addEventListener('mousedown', (e)=>{
        
        if(chckN&&chckP&&chckE){
            window.open (`mailto:admin@pizza.com?subject=Order&body=
            Ім'я:${customer.userName}; телефон:${customer.phone} e-mail:${customer.email}; 
            
            Розмір:${newOrder.size}; Соуси:${newOrder.sauce}; Топінг:${newOrder.topping}; Ціна${newOrder.price}грн. `)
             
        }
    })
    

    // Оголошуємо масив та змінну для перегортування
    let sliderArray = [3];
    let counter = 1;

    // Прописуємо "адреси" зображень
    sliderArray[0] = 'img/3.jpg';
    sliderArray[1] = 'img/Untitled-1.jpg';
    sliderArray[2] = 'img/слайдер-фотошоп2-938x340.jpg';

    // Слухаємо кнопки (стрілка ліво, стрілка право)
    $(document).keyup(function(e){
       
        if(e.key === 'ArrowLeft'){
            counter--;
            nextSlide(counter,e.type);
            
        } else if(e.key === 'ArrowRight'){
            counter++;
            nextSlide(counter,e.type);
        }
    })

    // для автоматичного перегортування
    const autoNext = () =>{
        counter++;
        nextSlide(counter);
    }

    // Таймер для автоматичного гортання
    const setT = () =>{
        setTimeout(autoNext, 15000);
       }

    // Запуск таймера після завантаження сторінки
    window.addEventListener('load',()=>{
        setT();
    })

    // Функція перегортування слайдера
    const nextSlide = (i,e)=>{
        if(i===3){
            i=0;
            counter=0;

            // встановлюємо властивості
            $(".slider_container__img").css({
                                            "background-image":"url("+sliderArray[i]+")",
                                            "background-size": "contain"    });
            //Перевіряємо звідки надішов наказ про перегортування => якщо не кнопка - запускаємо наступний відлік
            if (e!='keyup'){
               setT()
            } else {
               console.log('Ok')
            }
        } else if( i === -1){
            i = 2
            counter=2;
            $(".slider_container__img").css({
                                            "background-image":"url("+sliderArray[i]+")",
                                            "background-size": "contain"    });
            if (e!='keyup'){
                setT()
                } else {
                console.log('Ok')
                }
        } else {
            $(".slider_container__img").css({
                                            "background-image":"url("+sliderArray[i]+")",
                                            "background-size": "contain"    });
            if (e!='keyup'){
                setT()
                } else {
                console.log('Ok')
            }
        }
       
        
    }
})




