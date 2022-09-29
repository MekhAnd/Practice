import React from "react";
import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useLocation } from "react-router-dom/cjs/react-router-dom";
import { Redirect } from "react-router-dom/cjs/react-router-dom.min";

import { updateBlog, updateArt } from "../actions";
import { ALL_ART_ROUTE, ALL_BLOG_ROUTE } from "../utils/consts";
import {langUA_SaveThis} from "../utils/languagesUA"
import { langENG_SaveThis} from "../utils/languagesENG"

const EditComponent = ({ id, header, body, price }) => {
  const [newHeader, setHeader] = useState("");
  const [newBody, setBody] = useState("");
  const [newPrice, setPrice] = useState("");
  const [status, setStatus] = useState(false);

  const stateArray = [newHeader, newBody, newPrice];
  const fieldsArray = ["header", "body", "price"];

  const dispatch = useDispatch();
  const lang = useSelector((state)=>state.language)
  const location = useLocation();
  console.log(lang)

  const handleChanges = () => {
    const formData = new FormData();
    formData.append("id", id);
    console.log(fieldsArray);

    if (location.pathname.includes("blogs")) {
      console.log("Blogs Ok");
      for (let i = 0; i < stateArray.length; i++) {
        if (stateArray[i] !== "") {
          // console.log("blog");
          formData.append(fieldsArray[i], stateArray[i]);
        } else {
          continue;
        }
      }
      dispatch(updateBlog(formData));
      setStatus(true);
    } else if (location.pathname.includes("arts")) {
      // console.log("stateArray.length", stateArray.length);
      for (let i = 0; i < stateArray.length; i++) {
        console.log(i);
        if (stateArray[i] !== "") {
          console.log("art");
          formData.append(fieldsArray[i], stateArray[i]);
        } else {
          continue;
        }
      }
      // console.log("Exit");
      dispatch(updateArt(formData));
      setStatus(true);
    }
  };

  return (
    <div>
      {status ? (
        location.pathname.includes("arts") ? (
          <Redirect to={ALL_ART_ROUTE} />
        ) : (
          <Redirect to={ALL_BLOG_ROUTE} />
        )
      ) : (
        <div>
          <input
            className="mt-3"
            defaultValue={header}
            type="text"
            onChange={(e) => setHeader(e.target.value)}
          />
          {location.pathname.includes("arts") ? (
            <input
              className="mt-3"
              defaultValue={price}
              type="number"
              onChange={(e) => setPrice(e.target.value)}
            />
          ) : (
            <div></div>
          )}
          <textarea
            className="mt-3"
            cols={90}
            rows={15}
            defaultValue={body}
            onChange={(e) => {
              setBody(e.target.value);
            }}
          ></textarea>
          <button
            className="btn btn-dark mt-3"
            type="button"
            onClick={() => handleChanges()}
          >
            {lang === "ENG" ? langENG_SaveThis : langUA_SaveThis}
          </button>
        </div>
      )}
    </div>
  );
};

export default EditComponent;
