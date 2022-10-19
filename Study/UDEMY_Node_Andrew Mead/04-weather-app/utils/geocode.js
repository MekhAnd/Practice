const request = require("postman-request");

function geocode(address, callback) {
    const url = `http://api.positionstack.com/v1/forward?access_key=${process.env.GEOPOSITION_API_KEY}&query=${encodeURIComponent(
      address
    )}`;
  
    request({ url, json: true }, (error, {body}) => {
      if (error) {
        callback("Unable to connect to geo server");
      } else if (body.error) {
        callback("You should define location. Please try again!");
      } else if (!body.data[0]) {
        callback(
          "Unfortunatley we can not find this location, please try again!"
        );
      } else {
        return callback(undefined, {
          latitude: body.data[0].latitude,
          longitude: body.data[0].longitude,
          country: body.data[0].country
        });
      }
    });
  }

  module.exports = geocode