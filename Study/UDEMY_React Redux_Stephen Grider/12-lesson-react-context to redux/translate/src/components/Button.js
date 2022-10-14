import React from "react";
import LanguageContext from "../contexts/LanguageContext";
import ColorContext from "../contexts/ColorContext";

class Button extends React.Component {
  
  renderHelper(language) {
    return language === "english" ? "Submit" : "Підтвердити";
  }

  colorButton(colorValue) {
    return (
      <button className={`ui button ${colorValue}`}>
        <LanguageContext.Consumer>
          {({ language }) => this.renderHelper(language)}
        </LanguageContext.Consumer>
      </button>
    );
  }

  render() {
  return (
      <ColorContext.Consumer>
        {(colorValue) => this.colorButton(colorValue)}
      </ColorContext.Consumer>
    );
  }
}

export default Button;
