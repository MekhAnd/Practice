import React from "react";
import "./ImageList.css";
import ImageCard from "./ImageCard";

function SearchResult(props) {
  const photo = props.imageList.map((image) => {
    return <ImageCard key={image.id} image={image} />;
  });
  return <div className="image-list">{photo}</div>;
}
export default SearchResult;
