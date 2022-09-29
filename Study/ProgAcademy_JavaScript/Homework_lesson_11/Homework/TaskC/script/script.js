window.addEventListener('load',(e)=>{
    const button = document.getElementById('saleButt');
    // Слухаемо рух миші, коли миш над кнопкою - змінюємо координати за допомогою style
    button.addEventListener('mousemove', (e)=>{
        button.style.top = `${Math.floor(Math.random()*300)}px`;
        button.style.left = `${Math.floor(Math.random()*300)}px`;
    })
})