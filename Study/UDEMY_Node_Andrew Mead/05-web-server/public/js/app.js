const weatherForm = document.querySelector("form");
const searchRes = document.querySelector("input");
const message01 = document.querySelector("#message-1");
const message02 = document.querySelector("#message-2");



weatherForm.addEventListener("submit", (e) => {
  e.preventDefault();
  const userLocation = searchRes.value;
  message01.textContent = "Loading..."
  message01.textContent = "Waiting your location..."
  fetch(`http://localhost:3001/weather?address=${userLocation}`).then(
    (response) => {
      response.json().then((data) => {
        if (data.error) {
          message01.textContent = (data.error);
        } else {
            message01.textContent = `${data.latitude} ${data.longitude} ${data.address} ${data.country}`
            message02.textContent =  `${data.forecast.temperature} ${data.forecast.feelslike}`;
        }
      });
    }
  );
});

// : latitude,
//           : longitude,
//           : req.query.address,
//           : country,
//           forecast: forecastData,