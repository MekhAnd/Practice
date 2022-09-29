const checker = () =>{
    const loginJS = document.getElementById("login").value;
    const passJS = document.getElementById("pass").value
    console.log(loginJS + " " + passJS);

    if (loginJS==="admin"&& passJS==="1234"){
        let mess = document.getElementById("form-container__form");
        mess.innerHTML="Ви авторизовані";
        mess.style.color = "#6EBF8B";
        mess.style.fontWeight = "600";

    } else if (loginJS===""|| passJS===""){
        let mess = document.getElementById("form-container__form");
        mess.innerHTML="Ви не заповнили поля!";
        mess.style.color = "red";
        mess.style.fontWeight = "600";

    } else if (loginJS!="admin"&& passJS!="1234" ) {
        let mess = document.getElementById("form-container__form");
        mess.innerHTML="Вaш логін та пароль не знайдено";
        mess.style.color = "red";
        mess.style.fontWeight = "600";
        

    }
}