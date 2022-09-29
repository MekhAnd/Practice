import React, { useState } from "react";
import DropDown from "./DropDown";
import Convert from "./Convert";


// AIzaSyCHUCmpR7cT_yDFHC98CZJy2LTms-IwDlM

const options = [
    {
        label: "Afrikaans",
        value: "af"
    },
    {
        label: "Arabic",
        value: "ar"
    },
    {
        label: "Handi",
        value: "hi"
    },
    {
        label: "Ukrainian",
        value: "uk"
    },

]

const Translate = ()=>{
    const [language, setLanguage] = useState(options[0])
    const [text, setText] = useState ('');
    
    return(
        <div>
            <div className="ui form">
                <div className="field">
                    <label htmlFor="">Enter text</label>
                    <input value={text} onChange = {(e)=>setText(e.target.value)} type="text" />
                </div>
            </div>
            <DropDown 
                label = "Select a language"
                options={options}
                selected = {language}
                onSelectedChange={setLanguage}
                />
            <Convert
                text= {text}
                language = {language}
                />
            
        </div>
    )
};

export default Translate