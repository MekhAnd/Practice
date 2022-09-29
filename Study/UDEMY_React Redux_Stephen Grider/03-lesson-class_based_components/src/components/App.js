import React from "react";
// import { ReactDOM } from "react";
import "./App.css";
import Loader from "./Loader";
import SeasonDisplay from "./SeasonDisplay";


class App extends React.Component {
  state = { lat: null, errorMessage: "" };

  // ----------!!OTHER VARIANT IS:--------------------------//
  // constructor(props) {
  //   super(props);
  //   this.state = {
  //     lat: null,
  //     errorMessage: "",
  //   };
  // }

  componentDidMount() {
    window.navigator.geolocation.getCurrentPosition(
      (position) => this.setState({ lat: position.coords.latitude }),
      (err) => this.setState({ errorMessage: err.message })
    );
  }

  renderContent() {
    if (this.state.errorMessage && !this.state.lat) {
      return <div>Error : {this.state.errorMessage}</div>;
    }
    if (!this.state.errorMessage && this.state.lat) {
      return <SeasonDisplay lat={this.state.lat} />;
    }
    if (!this.state.errorMessage && !this.state.lat) {
      return <Loader message="Please accept location request!" />;
    }
  }

  render() {
    return (
          <div className="border red">{this.renderContent()}</div>
          );
  }
}

export default App;
