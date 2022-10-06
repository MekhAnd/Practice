import React from "react";
import { Button, Container } from "react-bootstrap";

import "../components/style/App.css"
import ArtCarousel from "../components/ArtCarousel";
import BlogCarousel from "../components/BlogCarousel";
import HashTags from "../components/HashTags";
import { useSelector } from "react-redux";
import { langENG_MainGreet, langENG_MainGreetSec, langENG_MainGreetThr } from "../utils/languagesENG";
import { langUA_MainGreet, langUA_MainGreetSec, langUA_MainGreetThr } from "../utils/languagesUA";

const Main = () => {
  const lang = useSelector((state)=>state.language)
  console.log(lang)
  return (
    <div>
      <Container>
      <div className="cover-photo"></div>
      <div className="greet-txt">
        <h1>{lang === "ENG" ? langENG_MainGreet : langUA_MainGreet}</h1> 
        <h3>{lang === "ENG" ? langENG_MainGreetSec : langUA_MainGreetSec}<br/> 
        {lang === "ENG" ? langENG_MainGreetThr : langUA_MainGreetThr}
        </h3> 
        </div>
        <div className="mouse-icon"></div>
      </Container>
      <ArtCarousel />
      <div className="blogs_hashtags align-content-start flex-wrap row">
        <BlogCarousel className = "col-6"/>
       
      </div>
    </div>
  );
};

export default Main;
