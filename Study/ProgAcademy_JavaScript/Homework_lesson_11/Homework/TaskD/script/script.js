let btn = document.addEventListener('keydown',(e)=>{
    // Відслідковуємо натискання кнопок клавіатури у випадку якщо одночасно натискаються CTRL та SHIFT з відповідною кнопкою
    // запускаємо модальне вікно
    if ((e.key === 's'&& e.ctrlKey&& !e.shiftKey)||(e.key === 'S'&& e.ctrlKey&& !e.shiftKey)||
                    (e.key === 'і'&& e.ctrlKey&& !e.shiftKey)||(e.key === 'І'&& e.ctrlKey&& !e.shiftKey)){
        
        alert("Збережено");
    } else if ((e.key === 'a'&& e.ctrlKey)||(e.key === 'A'&& e.ctrlKey)||
                    (e.key === 'ф'&& e.ctrlKey)||(e.key === 'Ф'&& e.ctrlKey)){
        
        alert("Обрано все");
    }  else if ((e.key === 'S'&& e.ctrlKey && e.shiftKey)||(e.key === 's'&& e.ctrlKey && e.shiftKey)||
                    (e.key === 'І'&& e.ctrlKey && e.shiftKey)||(e.key === 'і'&& e.ctrlKey && e.shiftKey)){

        alert("Збережено все");
    }
})