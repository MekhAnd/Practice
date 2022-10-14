import React from "react";
import LanguageContext from "../contexts/LanguageContext";
import ColorContext from "../contexts/ColorContext";

class Button extends React.Component {
  //   static contextType = LanguageContext; //FIRST => PRV) IDER

  renderHelper(value) {
    //!!!!SECOND WAY => CONSUMER
    return value === "english" ? "Submit" : "Підтвердити";
  }

  colorButton(colorValue){
    return(
        <button className={`ui button ${colorValue}`}>
            <LanguageContext.Consumer>
              {(value) => this.renderHelper(value)}
            </LanguageContext.Consumer>
            {/* {text} */}
            {/* FIRST => PRVIDER */}
          </button>
    )
  }

  render() {
    // const text = this.context ==="english"? "Submit":"Підтвердити" // FIRST => PROVIDER
    return (
      <ColorContext.Consumer>
        {(colorValue) => this.colorButton(colorValue)}
      </ColorContext.Consumer>
    );
  }
}

export default Button;
