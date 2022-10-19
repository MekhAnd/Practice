require("dotenv").config();
const request = require("postman-request");

//
// Goal: Create a reusable function for getting the forecast
//
// 1. Setup the "forecast" function in utils/forecast.js
// 2. Require the function in app.js and call it as shown below
// 3. The forecast function should have three potential calls to callback:
//    - Low level error, pass string for error
//    - Coordinate error, pass string for error
//    - Success, pass forecast string for data (same format as from before)

function forecast(latitude, longitude, callback) {
  const url = `http://api.weatherstack.com/current?access_key=${process.env.WEATHER_API_KEY}&query=${latitude},${longitude}`;
  request({ url, json:true }, (error, {body}) => {
    if (error) {
      callback("Unable to connect to weather service!");
    } else if (body.error) {
      callback("Please specify your location.");
    } else {
      callback(undefined, {
        temperature: body.current.temperature,
        feelslike: body.current.feelslike,
      });
    }
  });
}

module.exports = forecast;
