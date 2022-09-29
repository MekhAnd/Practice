window.addEventListener('DOMContentLoaded', (e)=>{
    // Слухаемо натискання кнопок клавіатури
    document.addEventListener('keydown', (e)=>{
        let div = document.querySelector('div');
        // змінюємо стиль елементу у відповідності до значення кнопки
        if(e.key === 'r'){
        
            div.style.color = 'red';
        } else if (e.key === 'b'){
        
            div.style.color = 'blue';
        } else if (e.key === 'g'){
        
            div.style.color = 'green';
        } else {
            return;
        }
    })
})