window.onload = () => {
  const options = {
    weekday: "short",
    month: "short",
    day: "numeric",
    year: "numeric",
  };

  /********** SET DATA **********/
  const date = new Date().toLocaleDateString("EN", options);
  const todayDay = document.querySelector(".header-greet__date");
  todayDay.innerHTML = `Today is ${date} `;
  let monthNumber = new Date().getMonth();

  /********** GET USER LOCATION **********/
  navigator.geolocation.getCurrentPosition((position) => {
    const userPosition = {
      latitude: position.coords.latitude,
      longitude: position.coords.longitude
    }
    
    const geoOptions={
      method:"POST",
      headers:{ "Content-Type": "application/json" },
      body: JSON.stringify(userPosition)
    }

    /***** Sending a request for weather data *****/
    fetch("/getforecast", geoOptions)
      
      .then((response)=>{return response.json()})
      /** Get data and draw...**/
      //Today container
      .then((response)=>{
        const weatherData = response.list;
        console.log(weatherData)
        const todayWeather = document.querySelector(
          ".weather-today__container_tmp"
        );
        const todayWeatherBtn = document.querySelector(
          ".icon-panel_today-weather"
        );
        todayWeather.innerHTML =
          Math.round(weatherData[0].main.temp) + "&#176;С";
        todayWeatherBtn.innerHTML = todayWeather.innerHTML;
        const todayIcon = document.querySelector("#day-forecast_icon");
        todayIcon.src =
          "http://openweathermap.org/img/wn/" +
          weatherData[0].weather[0].icon +
          "@2x.png";
        todayIcon.style.width = "75px";
        todayIcon.style.height = "75px";
        const todayForecast = document.querySelector(
          ".weather-today__container_forecast-container"
        );
        
        for (let i = 1; i < 5; i++) {
          let newHourForecast = document.createElement("div");
          newHourForecast.className = "today-weather_";
          newHourForecast.style.lineHeight = "2.5";
          let textDate = weatherData[i].dt_txt;
          newHourForecast.innerHTML =
            textDate.substr(11, 5) +
            " " +
            Math.round(weatherData[i].main.temp) +
            "&#176;С";
          let newHourForecastIcon = document.createElement("div");
          let newHourForecastImg = document.createElement("img");
          newHourForecastImg.setAttribute(
            "src",
            `http://openweathermap.org/img/wn/${weatherData[i].weather[0].icon}@2x.png`
          );
          todayForecast.appendChild(newHourForecast);
          todayForecast.appendChild(newHourForecastIcon);
          newHourForecastIcon.appendChild(newHourForecastImg);
        }

        const weatherForecast = document.querySelector(".main_weather");
        //Next 5 days container
        for (let i = 5; i < 40; ) {
          let textDate = weatherData[i].dt_txt;
          if (textDate.includes("12:00")) {
            let newDayForecast = document.createElement("div");
            newDayForecast.className = "main_weather__daily-forecast";
            let newDayForecastDay = document.createElement("div");
            newDayForecastDay.className = "main_weather__daily-forecast-date";
            newDayForecastDay.innerHTML = `${textDate.substr(8,2)}.${textDate.substr(5, 2)}`;
            let newDayForecastTmp = document.createElement("div");
            newDayForecastTmp.className = "main_weather__daily-forecast-tmp";
            newDayForecastTmp.innerHTML =
              Math.round(weatherData[i].main.temp) + "&#176;С";
            let newDayForecastIcon = document.createElement("img");
            newDayForecastIcon.src = `http://openweathermap.org/img/wn/${weatherData[i].weather[0].icon}@2x.png`;
            newDayForecastIcon.id = "main_weather-icon";
            weatherForecast.appendChild(newDayForecast);
            newDayForecast.appendChild(newDayForecastDay);
            newDayForecast.appendChild(newDayForecastIcon);
            newDayForecast.appendChild(newDayForecastTmp);
          }
          i = i + 1;
        }
      });
  });
  /********** Sending a request for something very clever **********/
  axios.get(`https://type.fit/api/quotes`).then((response) => {
    const quote = document.querySelector(".header-greet__quotes");
    const quoteContent = document.createElement("h3");
    const mainArray = Math.round(Math.random() * response.data.length);
    quoteContent.innerHTML = `${response.data[mainArray].text} <br/> ${response.data[mainArray].author}`;

    quote.appendChild(quoteContent);
  });
};

calendar(monthNumber);

setInterval(() => {
  const time = new Date().toLocaleTimeString();
  const todayTime = document.querySelector(".header-greet__time");
  todayTime.innerHTML = `${time}`;
}, 1000);
