import React from "react";
import "./Stopwatch.css"

function Round(props) {
  const circle = props.rounds.map((element, index, laps) => {
    return (
      <div key={index} className="row">
        <div className="lap"><b>Lap {index+1}:</b> </div>
        <div>
          {Math.trunc(element / 1000 / 60) < 10
            ? `0${Math.trunc(element / 1000 / 60)}`
            : Math.trunc(element / 1000 / 60)}
        </div>
        <div className="point">:</div>
        <div>
          {Math.trunc(element / 1000) % 60 < 10
            ? `0${Math.trunc(element / 1000) % 60}`
            : Math.trunc(element / 1000) % 60}
        </div>
        <div className="point">.</div>
        <div>{element % 1000 < 10 ? `00${element % 1000}` : element % 1000 < 100 ? `0${element % 1000}` : element % 1000}</div>
      </div>
    );
  });

  return <div className="main_monitor__lap">{circle}</div>;
}

export default Round;
