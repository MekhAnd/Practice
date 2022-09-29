/***Handling buttons and panels on screen ***/

const currentWeatherIcon = document.querySelector(".icon-panel_today-weather");
const currentCalendarIcon = document.querySelector(
  ".header__icon-panel_calendar"
);
const currentWeatherForecastIcon = document.querySelector(
  ".header__icon-panel_forecast-4days"
);

const currentWeatherForecast = document.querySelector(
  ".weather-today__day-forecast"
);
const currentCalendarPanel = document.querySelector(".calendar_on");
const currentForecastPanel = document.querySelector(".main_weather");
const currentToDoList = document.querySelector(".header-todo__todo")

const rightMenuMinimize = document.querySelector(
  ".navabar-right-side__hamburger"
);
const rightMenu = document.querySelector(".menu");

const loginIcon = document.querySelector(".navbar_login");
const loginModal = document.querySelector(".modal-login");

const availableScreenWidth = window.screen.availWidth;

const user = "";

loginIcon.addEventListener("click", () => {
  loginModal.style.display = "block";
});

window.onclick = function (event) {
  if (event.target === loginModal) {
    loginModal.style.display = "none";
  }
};

/********** Handling buttons and panels**********/
//On small screens оnly one panel may be opened 
currentWeatherIcon.addEventListener("click", () => {
  if (window.getComputedStyle(currentWeatherForecast).display === "none") {
    if (availableScreenWidth < 1024) {
      currentCalendarPanel.style.display = "none";
      currentForecastPanel.style.display = "none";
      currentToDoList.style.display = "none"; 
      currentCalendarIcon.removeAttribute("disabled");
    }
    currentWeatherForecast.style.display = "block";
  } else {
    currentWeatherForecast.style.display = "none";
  }
});

//...and handling to-do list (if to-do list was opened=>close to-do panel)
currentCalendarIcon.addEventListener("click", () => {
  if (window.getComputedStyle(currentCalendarPanel).display === "none") {
    currentToDoList.style.display = "none";
    if (availableScreenWidth < 1024) {
      currentWeatherForecast.style.display = "none";
      currentForecastPanel.style.display = "none";
      currentToDoList.style.display = "none";
      currentCalendarIcon.removeAttribute("disabled");
    }
    currentCalendarPanel.style.display = "block";
  } else {
    currentCalendarPanel.style.display = "none";
  }
});

currentWeatherForecastIcon.addEventListener("click", () => {
  if (window.getComputedStyle(currentForecastPanel).display === "none") {
    if (availableScreenWidth < 1024) {
      currentWeatherForecast.style.display = "none";
      currentCalendarPanel.style.display = "none";
      currentToDoList.style.display = "none";
      currentCalendarIcon.removeAttribute("disabled");
    }
    currentForecastPanel.style.display = "flex";
  } else {
    currentForecastPanel.style.display = "none";
  }
});

//rolling the right part of the menu
rightMenuMinimize.addEventListener("click", () => {
  if (rightMenu.style.display === "flex") {
    rightMenu.style.display = "none";
    rightMenu.style.flexDirection = "row";
    rightMenu.style.top = "0";
  } else if(availableScreenWidth < 1024) {
    rightMenu.style.display = "flex";
    rightMenu.style.flexDirection = "column";
    rightMenu.style.top = "48%";
    rightMenu.style.zIndex = "10";
    rightMenu.style.borderShadow =
      "0px 0px 33px 10px rgba(255, 255, 255, 0.45);";
  }
});
