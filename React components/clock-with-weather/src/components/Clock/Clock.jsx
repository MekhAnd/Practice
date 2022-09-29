import React from "react";

// This component 

class Clock extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      time: null,
      date: null,
      gradient: 0,
    };
  }


  gradientDefinition(props) {
    let timeNow = new Date();
    timeNow = Number(timeNow.toLocaleTimeString([], { hour: "2-digit" }));

    const sunR = Number(
      new Date(this.props.sunRise * 1000).toLocaleTimeString([], {
        hour: "2-digit",
      })
    );
    const sunS = Number(
      new Date(this.props.sunSet * 1000).toLocaleTimeString([], {
        hour: "2-digit",
      })
    );

    const monitor = document.querySelector(".geo-time");
    let gradient;
    if (timeNow > sunR && timeNow < sunS) {
      gradient = Math.round((100 / (sunS - sunR)) * (timeNow - sunR));
      this.setState({ gradient: gradient });
      console.log(this.state.gradient);
      return (monitor.style.background = `linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(0,212,255,1) 
            ${gradient}%, rgba(9,9,121,1) 100%)`);
    } else {
      if (timeNow < 24) {
        gradient = (100 / (24 - (sunS - sunR))) * (timeNow - sunS);
        this.setState({ gradient: gradient });
        return (monitor.style.background = `linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(0,212,255,1) 
            0%, rgba(9,9,121,1) ${gradient}%)`);
      } else {
        gradient =
          (100 / (24 - (sunS - sunR))) * (24 - sunS + (sunR - timeNow));
        this.setState({ gradient: gradient });
        return (monitor.style.background = `linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(0,212,255,1) 
            0%, rgba(9,9,121,1) ${gradient}%)`);
      }
    }
  }

  componentDidMount() {
    const currentDate = new Date().toLocaleDateString([], {
      weekday: "short",
      year: "numeric",
      day: "numeric",
      month: "long",
    });
    this.setState({ date: currentDate });

    setInterval(() => {
      const currentTime = new Date().toLocaleTimeString([], {
        hour: "2-digit",
        minute: "2-digit",
      });

      this.setState({ time: currentTime });
    }, 1000);

    setInterval(() => {
      this.gradientDefinition();
    }, 600000);
  }

  render() {
    return (
      <div>
        <div className="geo-time_monitor date">{this.state.date}</div>
        <div className="geo-time_monitor time">{this.state.time}</div>
      </div>
    );
  }
}

export default Clock;
