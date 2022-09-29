import React from "react";
import { Button, Container } from "react-bootstrap";

import "../components/style/App.css"
import ArtCarousel from "../components/ArtCarousel";
import BlogCarousel from "../components/BlogCarousel";
import HashTags from "../components/HashTags";

const Main = () => {
  return (
    <div>
      <ArtCarousel />
      <div className="blogs_hashtags align-content-start flex-wrap row">
        <BlogCarousel className = "col-6"/>
       
      </div>
    </div>
  );
};

export default Main;
