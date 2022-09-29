window.addEventListener('load', (e)=>{
    let prev = document.getElementById('prev');
    let next = document.getElementById('next');
    let container = document.getElementById('slider');
    let pointer = document.querySelectorAll('li');
    let array = [6];
    
    // "Слухач" для номерів фото в слійдері - викликає ф-цію з 
    // відповідним ID який є адресою в масиві фото
    for(let j = 0; j< pointer.length; j++){
        let point = pointer[j];
        point.addEventListener('click', function (e){
            console.log(e.target.id)
            turnOv(e.target.id)
        })
    }

    // Створюємо масив фото
    array[0] = 'url(../TaskA/images/IMG_20190707_212246.jpg' 
    array[1] = 'url(../TaskA/images/IMG_20190708_144128.jpg)' 
    array[2] = 'url(../TaskA/images/IMG_20190708_175945.jpg)' 
    array[3] = 'url(../TaskA/images/IMG_20190709_162221.jpg)' 
    array[4] = 'url(../TaskA/images/IMG_20190710_210901.jpg)' 
    array[5] = 'url(../TaskA/images/IMG_20190709_100157.jpg)' 

    let i = array.length - 1;
    let k = 0;
   
    // слухаємо кнопку попередня, якщо ок (розраховуємо наступний слайд 
    // та викликаємо ф-цію з адресою фото в масиві )
    prev.addEventListener('click', function(e) {
        console.log("click + " + i)
        if (i === -1){
            i = array.length-1;
        }
        turnOv(i); 
        i--;
    })

    // слухаємо кнопку наступний, якщо ок (розраховуємо наступний слайд 
    // та викликаємо ф-цію з адресою фото в масиві )
    next.addEventListener('click', function(e) {
        console.log("click + " + k)
        if (k === 6){
            k = 0;
        }
        turnOv(k); 
        k++;
    })

    // ф-ція заміни фото
    const turnOv = (i) =>{
        console.log(array[i])
        container.style.background = array[i];
        container.style.backgroundSize = "contain"
        container.style.backgroundPosition= "center"; 
        container.style.backgroundRepeat= "no-repeat";
        
    }
})