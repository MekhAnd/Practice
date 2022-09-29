import React, { useState } from "react";
import { useEffect } from "react";
import "./Stopwatch.css";
import Button from "./Button";
import Round from "./Round";

function Stopwach() {
  const [timer, setTimer] = useState(0);
  const [start, setStart] = useState(false);
  const [round, setRound] = useState([]);
  const [globeTimer, setGlobeTimer] = useState(0);

  const userBrowserDefinition = () => {
    let respond = navigator.userAgent;
    if (respond.includes("Chrome")) {
      return 4;
    } else {
      return 16;
    }
  };

  useEffect(() => {
    let secondsCircle = document.querySelector(".svg01");
    let milCircle = document.querySelector(".svg02");
    let degreeS = 0;
    let degreeM = 0;

    degreeS = timer / 166.6666666666667;
    secondsCircle.style.transform = `rotate(${degreeS}deg)`;
    degreeM = timer / 3.6;
    milCircle.style.transform = `rotate(${degreeM}deg)`;
  }, [timer]);

  function Circle() {
    if (round.length < 10) {
      if (round.length === 0) {
        round[round.length] = timer;
        setRound(round);
      } else {
        round[round.length] = timer - globeTimer;
        setRound(round);
      }
    } else {
      let firstElement = Math.min.apply(Math, round);
      round.length = 0;
      round[0] = firstElement;
      round[round.length] = timer - globeTimer;
      setRound(round);
    }
    setGlobeTimer(timer);
  }

  useEffect(() => {
    let interval;
    const timerNow = new Date().getTime();
    if (start) {
      interval = setInterval(() => {
        const now = new Date().getTime();
        const pass = now - timerNow;
        // console.log(pass)
        setTimer(Number(pass));
      }, 1);
    } else {
      clearInterval(interval);
    }
    return () => {
      clearInterval(interval);
    };
  }, [start]);

  function go() {
    setStart(!start);
  }

  function clear() {
    setTimer(0);
    setRound([]);
    setGlobeTimer([]);
  }

  return (
    <div className="main_monitor">
      <div className="svg">
        <div className="svg01"></div>
        <div className="svg02"></div>
      </div>
      <div className="main_monitor__timer">
        <div className="mill">
          {Math.trunc(timer / 1000 / 60) < 10
            ? `0${Math.trunc(timer / 1000 / 60)}`
            : Math.trunc(timer / 1000 / 60)}
        </div>
        <div className="point">:</div>
        <div className="mill">
          {Math.trunc(timer / 1000) % 60 < 10
            ? `0${Math.trunc(timer / 1000) % 60}`
            : Math.trunc(timer / 1000) % 60}
        </div>
        <div className="point">.</div>
        <div className="mill">
          {timer % 1000 < 10
            ? `00${timer % 1000}`
            : timer % 1000 < 100
            ? `0${timer % 1000}`
            : timer % 1000}{" "}
        </div>
      </div>
      <div className="main_monitor__btns">
        <Button go={go} btn={"play"} />
        <Button go={go} btn={"stop"} />
        <Button go={clear} btn={"recycle"} />
        <Button go={Circle} btn={"history"} />
      </div>
      <Round rounds={round} />
    </div>
  );
}

export default Stopwach;
