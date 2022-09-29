import React from "react";


function Button(props) {
  console.log(props)
  return (
    <button className="ui circular red button" onClick={props.go}>
      <i className={`${props.btn} big circle icon btn-icon`}></i>
    </button>
  );
}
export default Button;
