import React from "react";

function Loader(props) {
  return (
    <div className="ui active dimmer">
        <div className="ui big text loader">{props.message} </div>
    </div>
    
    
  );
}
Loader.defaultProps = {
    message: "Load..."
}

export default Loader;
