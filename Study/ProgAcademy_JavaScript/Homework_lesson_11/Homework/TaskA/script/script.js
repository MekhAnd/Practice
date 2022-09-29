window.addEventListener('DOMContentLoaded', (e)=>{
    //Вводимо змінну для визначення натискання кнопки зберігти
    var save = false;
    let text = document.querySelector('textarea');

    //слухаємо кнопку
    let click = document.addEventListener('click', function (e) {
        let button = document.querySelector('button');
        //якщо натиснута кнока - змінна стає true
        if(e.target.id === 'button'){
            save = true;
        }
    })
    
    //Слухаємо закриття вікна
    window.onbeforeunload = function(e) {
        // Діалог змінити не вийшло
        let dialog = "Ви не зберігли текст!"
        e.returnValue = dialog; 

        //якщо хмінна false - вивести попередження
        if(!save){
            return e.returnValue;
        }
          
      };
})
