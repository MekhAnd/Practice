import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import "./Timer.css";

function Timer() {
  //to determine the initial state
  const [fullDate, setFullDate] = useState({
    d: new Date().getDate(),
    m: new Date().getMonth(),
    y: new Date().getFullYear(),
    h: new Date().getHours(),
    min: new Date().getMinutes(),
    seconds: new Date().getSeconds(),
  });
  const [seconds, setSeconds] = useState(0);
  const [minutes, setMinutes] = useState(0);
  const [hours, setHours] = useState(0);
  const [days, setDays] = useState(0);
  const [clock, setClock] = useState(false);

 
  const input = document.querySelector(".main-timer_timer-panel__input");
  const timer = document.querySelector(".main-timer_timer-panel__timer");
  const sbmBtn = document.querySelector(".main-timer_timer-panel__input-btn");
  const startBtm = document.querySelector(
    ".main-timer_button-panel__container"
  );

  let interval;

  const countDown = () => {
    const definiteDay = new Date(
      fullDate.y,
      fullDate.m,
      fullDate.d,
      fullDate.h,
      fullDate.min
    ).getTime();
    interval = setInterval(() => {
      const today = new Date().getTime();
      const pass = definiteDay - today;

      const days = Math.floor(pass / (1000 * 60 * 60 * 24));
      const hours = Math.floor(
        (pass % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
      );
      const minutes = Math.floor((pass % (1000 * 60 * 60)) / (1000 * 60));
      const seconds = Math.floor((pass % (1000 * 60)) / 1000);

      if (pass <= 0 || !clock) {
        clearInterval(interval);
      }

      setDays(days);
      setHours(hours);
      setMinutes(minutes);
      setSeconds(seconds);
    }, 1000);
  };

  useEffect(() => {
    countDown();
    return () => clearInterval(interval);
  }, [clock]);

  const dateSetter = () => {
    input.style.display = "block";
    timer.style.display = "none";
    sbmBtn.style.display = "block";
    startBtm.style.display = "none";
  };

  const dateSet = () => {
    input.style.display = "none";
    timer.style.display = "block";
    sbmBtn.style.display = "none";
    startBtm.style.display = "flex";
    countDown();
    setClock(true);
  };

  const onInputChange = (e) => {
    const dateTime = e.target.value;

    let day = dateRevision(dateTime.substr(0, 2));
    let month = dateRevision(dateTime.substr(3, 2));
    let year = dateRevision(dateTime.substr(6, 4));

    let hour = dateRevision(dateTime.substr(11, 2));
    let min = dateRevision(dateTime.substr(14, 2));

    setFullDate({ d: day, m: month - 1, y: year, h: hour, min: min });
  };

  const dateRevision = (data) => {
    if (data.indexOf("0") === 0) {
      data = data.replace("0", "");
      return data;
    } else {
      return data;
    }
  };

  const clear = () => {
    setClock(false);
    setFullDate({
      d: new Date().getDate(),
      m: new Date().getMonth(),
      y: new Date().getFullYear(),
      h: new Date().getHours(),
      min: new Date().getMinutes(),
      seconds: new Date().getSeconds(),
    });
  };

  return (
    <div className="main-timer">
      <div className="main-timer_button-panel">
        <button className="setter-date_btn" onClick={dateSetter}>
          <i className="clock outline icon setter-date"></i>
        </button>
      </div>
      <div className="main-timer_timer-panel">
        <div className="main-timer_timer-panel__input">
          <input
            className="main-timer_timer-panel__input-txt"
            type="text"
            placeholder="dd.mm.year hh.mm"
            onChange={(e) => onInputChange(e)}
          />
        </div>
        <div className="main-timer_timer-panel__timer">
          <div className="main-timer_timer-panel__timer-day">
            <div className="days">{days < 0 ? "0" : days}</div>
            <span>{days < 2 ? `day` : `days`}</span>
          </div>
          <div className="main-timer_timer-panel__timer-time_">
            <div className="days">
              {hours < 0 ? "00" : hours < 10 ? `0${hours}` : hours}
            </div>
            <div>:</div>
            <div className="days">
              {minutes < 0 ? "00" : minutes < 10 ? `0${minutes}` : minutes}
            </div>
            <div>:</div>
            <div className="days">
              {seconds < 0 ? "00" : seconds < 10 ? `0${seconds}` : seconds}
            </div>
          </div>
        </div>
      </div>
      <div className="main-timer_button-panel">
        <div className="main-timer_button-panel__container">
          {!clock ? (
            <button
              className="main-timer_button-panel__container-btns"
              onClick={() => setClock(true)}
            >
              <i className="play icon"></i>
            </button>
          ) : (
            <button
              className="main-timer_button-panel__container-btns"
              onClick={clear}
            >
              <i className="trash alternate icon"></i>
            </button>
          )}

          <button
            className="main-timer_button-panel__container-btns"
            onClick={() => setClock(false)}
          >
            <i className="pause icon"></i>
          </button>
        </div>
        <button className="main-timer_timer-panel__input-btn" onClick={dateSet}>
          <i className="check icon sbm_icon"></i>
        </button>
      </div>
    </div>
  );
}

export default Timer;
