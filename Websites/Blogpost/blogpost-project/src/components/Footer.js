import React from "react";
import { Container } from "react-bootstrap";

import "../components/style/Footer.css"

const Footer =()=>{
    return (
        
        <div className="footer">
           <div className="footer_info">
                {/* <div>FIND ME HERE:</div> */}
                <a href="#"><div className="footer_info__logo-fb"></div></a>
                <a href="#"><div className="footer_info__logo-pin"></div></a>
                <a href="#"><div className="footer_info__logo-ins"></div></a>
                <a href="#"><div className="footer_info__logo-tw"></div></a>
           </div>
           <div className="footer_logo"></div>
        </div>
        
    )
}

export default Footer


//