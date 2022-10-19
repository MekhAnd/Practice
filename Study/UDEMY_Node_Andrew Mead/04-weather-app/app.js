const geocode = require("./utils/geocode");
const forecast = require("./utils/forecast");

const userLocation = process.argv[2]

geocode(userLocation, (error, {latitude, longitude, country}={}) => {
  if (error) {
    return console.log(("Error", error));
  }

  forecast(latitude, longitude, (error, forecastData) => {
    if (error) {
      return console.log(("Error", error));
    }
    console.log("Data location", latitude, longitude, country);
    console.log("Data forecast", forecastData);
  });
});
