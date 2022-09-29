import React from "react";
import CurrentWeather from "./CurrentWeathe";
import "./GeoTimeROOT.css";

//Root component which responsible only for take the user geo position. 
// After fetching the position, the component will send this position to the descendants

class GeoTime extends React.Component {
  state = { time: null, lat: null, long: null, errMessage: "" };

  componentDidMount() {
    window.navigator.geolocation.getCurrentPosition(
      (position) =>
        this.setState({
          lat: position.coords.latitude,
          long: position.coords.longitude,
        }),
      (err) => this.setState({ errMessage: err.message })
    );
  }

  render() {
    return (
      <div className="geo-time">
        <CurrentWeather
          lat={this.state.lat}
          long={this.state.long}
          err={this.state.errMessage}
        />
      </div>
    );
  }
}

export default GeoTime;
