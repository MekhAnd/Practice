import React from "react";
import axios from "axios";
import { REACT_APP_OWM_API } from "./env";
import Clock from "./Clock";

// This component receives user coordinates and send request into https://api.openweathermap.org/ API
// if user coordinates was not received - this component will send other request into http://ip-api.com/ 
// to catch coordinates by user IP and after that send request into https://api.openweathermap.org/ API
// After fetch data from OpenWeatherMap, component rendering some data personaly and sending sunrise and 
// sunset time into Clock`s component like properties 

class CurrentWeather extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      lat: this.props.lat,
      long: this.props.long,
      errMessage: this.props.errMessage,
      userCity: "",
      userCountry: "",
      locationSR: 0,
      locationSS: 0,
      userCurrenWeather: 0,
      weatherInf: "",
    };
  }

  async componentDidMount() {
    if (this.state.lat !== null) {
      axios
        .get(
          `https://api.openweathermap.org/data/2.5/weather?lat=${this.state.lat}&lon=${this.state.long}&appid=${REACT_APP_OWM_API}&units=metric`
        )
        .then((response) => {
          this.setState({
            ...this.state,
            userCity: response.data.name,
            userCountry: response.data.sys.country,
            locationSR: response.data.sys.sunrise,
            locationSS: response.data.sys.sunset,
            userCurrenWeather: Math.round(response.data.main.temp),
            weatherInf:
              "http://openweathermap.org/img/wn/" +
              response.data.weather[0].icon +
              "@2x.png",
          });
          });
    } else {
      axios.get(`http://ip-api.com/json/`).then((response) => {
        axios
          .get(
            `https://api.openweathermap.org/data/2.5/weather?lat=${response.data.lat}&lon=${response.data.lon}&appid=${REACT_APP_OWM_API}&units=metric`
          )
          .then((resp) => {
            this.setState({
              ...this.state,
              userCity: resp.data.name,
              userCountry: resp.data.country,
              locationSR: resp.data.sys.sunrise,
              locationSS: resp.data.sys.sunset,
              userCurrenWeather: Math.round(resp.data.main.temp),
              weatherInf:
                "http://openweathermap.org/img/wn/" +
                resp.data.weather[0].icon +
                "@2x.png",
            });
          });
      });
    }
  }

  render() {
    console.log(this.state.userCity)
    return (
      <div className="geo-time_monitor">
        <div className="geo-time_monitor temp">
          {this.state.userCurrenWeather}&#176;C
        </div>
        <div className="geo-time_main_monitor">
          <Clock
            sunRise={this.state.locationSR}
            sunSet={this.state.locationSS}
          />
          <div className="geo-time_monitor position">
            {this.state.userCity},&#160;{this.state.userCountry}
          </div>
        </div>
        <div className="geo-time_monitor weather-icon">
          <img src={this.state.weatherInf} alt="" />
        </div>
      </div>
    );
  }
}

export default CurrentWeather;
