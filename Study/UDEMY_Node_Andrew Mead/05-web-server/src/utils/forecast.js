require("dotenv").config();
const request = require("postman-request");

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
