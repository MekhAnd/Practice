import React from "react";
import "./style/Input.css";

const Input = ({ type, placeholder, value, setValue }) => {
  return <input className="input"
                value= {value}
                type={type} 
                placeholder={placeholder}
                onChange={(e)=>{setValue(e.target.value)}}
                />;
};

export default Input;
