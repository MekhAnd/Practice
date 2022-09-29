let currentUser = {};

const loginBtn = document.querySelector(".modal-login-btn");
loginBtn.addEventListener("click", (e) => {
  const loginUserEmail = document.getElementById("userEmailLogIn");
  const userEmail = loginUserEmail.value.toLowerCase();
  const loginUserPass = document.getElementById("userPassLogIn");
  const userPass = loginUserPass.value;
  const authInfo = document.querySelector(".modal-login-info");
  const loginWithPanel = document.querySelector(".modal-login-with");
  const closeInfoBtn = document.querySelector(".infoAuthLogin");

  emailChecker(loginUserEmail);

  const checkUser = (currentUser = {
    userEmail: userEmail,
    userPass: userPass,
  });

  const options = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(checkUser),
  };

  fetch("/login", options)
    .then((response) => {
      return response.json();
    })
    .then((jsponse) => {
      if (jsponse.status != 200) {
        fieldValueCleaner([loginUserEmail, loginUserPass]);
        authInfo.style.display = "block";
        loginWithPanel.style.display = "none";
        authInfo.innerHTML = `<br> ${jsponse.err}`;
        authInfo.style.lineHeight = "1.5";
        authInfo.style.fontSize = "1em";
        authInfo.style.color = "red";
        authInfo.style.textAlign = "left";
        closeInfoBtn.style.display = "inline-block";
        closeInfoBtn.addEventListener("click", (e) => {
          authInfo.style.display = "none";
          authInfo.innerHTML = "";
          closeInfoBtn.style.display = "none";
          loginWithPanel.style.display = "block";
        });
      } else {
        let userName = jsponse.err;
        lock(userName);
      }
    })
    .catch((err) => {
      if (err) {
        console.log(JSON.stringify(err));
      }
    });

  const lock = (userName) => {
    if (emailChecker(loginUserEmail)) {
      loginModal.style.display = "none";
      const greeting = document.querySelector(".header-greet-user");
      const time = new Date();
      if (time.getHours() < 12) {
        greeting.innerHTML = `Доброго ранку!`;
      } else if (time.getHours() < 18) {
        greeting.innerHTML = `Доброго дня!`;
      } else if (time.getHours() < 22) {
        greeting.innerHTML = `Добрий вечір!`;
      } else if (time.getHours() > 22 && time.getHours() < 6) {
        greeting.innerHTML = `Доброї ночі!`;
      }
    }
    fieldValueCleaner([loginUserEmail, loginUserPass]);
  };
});

function emailChecker(registrationUserEmail) {
  const emailCheck = registrationUserEmail;
  console.log("registrationUserEmail", registrationUserEmail.value)
  if (
    emailCheck.value.length >= 6 &&
    emailCheck.value.includes("@") &&
    emailCheck.value.includes(".")
  ) {
    return true;
  } else {
    registrationUserEmail.value = "";
    registrationUserEmail.placeholder = "Incorrect e-mail";
    registrationUserEmail.style.background = "black";
    registrationUserEmail.style.color = "red";
    return false;
  }
}

const fieldValueCleaner = (array) => {
  array.forEach((element) => {
    element.value = "";
  });
};
