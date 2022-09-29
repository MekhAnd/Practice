import React from "react";
import ReactDOM from "react-dom";

const App = ()=>{
    return( 
    <div>
        
        <label className="lable" htmlFor="name"/>
            Enter name:
        <label />
        <input id="name" type="text" />
        <button style = {{backgroundColor:"blue", color: "white"}}>Submit </button>
    </div>
    )
}

ReactDOM.render(
    <App/>,
    document.querySelector('#root')
)