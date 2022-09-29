const registrationUserEmail = document.getElementById("userEmail");
const registrationUserPass = document.getElementById("userPass");
const registrationBtn = document.querySelector(".registration-btn");

registrationBtn.setAttribute("hidden", true)

registrationUserEmail.addEventListener('change', e=>{
  const userEmail=e.target.value;
  console.log(e.target.value)
  if(emailChecker(e.target)){
    registrationBtn.removeAttribute("hidden");
    listenPass(userEmail)
    
  }
})

const listenPass = (userEmail)=>{
  registrationBtn.addEventListener("click", (e) => {
  
    const infoPanel = document.querySelector("article");
    const warning = document.createElement("div");
  
    const newUser = (currentUser = {
      userEmail: userEmail,
      userPass: userPass,
    });
  
    const options = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newUser),
    };
  
    fetch("/registration", options)
      .then((response) => {
        return response.json();
      })
      .then((jsponse) => {
        if (jsponse.status != 200) {
          fieldValueCleaner([registrationUserEmail, registrationUserPass]);
          warning.innerHTML = `<br> ${jsponse.err}`;
          warning.style.cssText =
            "line-height: 1.5; font-size: 1em; color:red; text-align:left;";
          infoPanel.appendChild(warning);
        } else {
          lock();
        }
      })
      .catch((err) => {
        console.log(JSON.stringify(err));
      });
    
      const time = new Date();
      if (time.getHours() < 12) {
        greeting.innerHTML = `Доброго ранку!`;
      } else if (time.getHours() < 18) {
        greeting.innerHTML = `Доброго дня!`;
      } else if (time.getHours() < 22) {
        greeting.innerHTML = `Добрий вечір!`;
      } else if (time.getHours() > 22 && time.getHours() < 6) {
        greeting.innerHTML = `Добрий ночі!`;
      }
  
      fieldValueCleaner([registrationUserEmail, registrationUserPass]);
    
  });
  
}


