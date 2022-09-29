import React, { useState } from "react";
import ReactQuill from "react-quill";
import { useDispatch } from "react-redux";
import { Container, Button } from "react-bootstrap";

import { createArt } from "../actions";
import { Redirect } from "react-router-dom";
import { ALL_ART_ROUTE } from "../utils/consts";

const modules = {
  toolbar: [
    [{ font: [] }],
    [{ header: [1, 2, 3, 4, 5, 6, false] }],
    ["bold", "italic", "underline", "strike"],
    [{ color: [] }, { background: [] }],
    [{ script: "sub" }, { script: "super" }],
    ["blockquote"],
    [{ list: "ordered" }, { list: "bullet" }],
    [{ indent: "-1" }, { indent: "+1" }, { align: [] }],
    ["link", "image", "video"],
    ["clean"],
  ],
};

const CreateArt = () => {
  const [body, setBody] = useState("");
  const [header, setHeader] = useState("");
  const [cover, setCover] = useState();
  const [price, setPrice] = useState(0);
  const [sent, setStatus] = useState(false);
  const dispatch = useDispatch();

  const createEntry = () => {
    const formData = new FormData();
    formData.append("header", header);
    formData.append("body", body);
    formData.append("photo", cover);
    formData.append("price", price);
    formData.append("hashtag", null);
    dispatch(createArt(formData));
    setStatus(true);
  };

  return (
    <Container className="mt-5" style={{ minHeight:"calc(100vh - 65px)"}}>
      {sent ? (
        <Redirect to={ALL_ART_ROUTE} />
      ) : (
        <div>
          <input
            className="form-control input-group"
            type="text"
            placeholder="It`s will be header for your next handmade..."
            value={header}
            onChange={(event) => setHeader(event.target.value)}
          />

          <div className="form-control mb-2 mt-2 d-flex flex-row justify-content-around">
            <div style={{ width: "50%" }}>
              <label
                style={{ backgroundColor: "gray", color:"white" }}
                className="form-control label p-2 bd-highlight"
                htmlFor="customFileLang"
              >
                <b>Choose photo here...</b>
              </label>
              <input
                type="file"
                className="form-control p-2 bd-highlight"
                id="customFileLang"
                onChange={(e) => setCover(e.target.files[0])}
              />
            </div>
            <div style={{ width: "50%" }}>
              <label
                style={{ backgroundColor: "gray", color:"white" }}
                className="form-control label p-2 bd-highlight"
                htmlFor="customFileLang"
              >
                <b>Set price here...</b>
              </label>
              <input
                type="number"
                className="form-control p-2 bd-highlight"
                id="customFileLang"
                onChange={(e) => setPrice(e.target.value)}
              />
            </div>
          </div>
          <div className="editor" style={{ backgroundColor: "white" }}>
            <ReactQuill modules={modules} theme="snow" onChange={setBody}/>
          </div>
          <div className="d-grid gap-2 mt-3 mb-3">
            <Button
              variant="dark outline-secondary"
              size="lg"
              onClick={createEntry}
            >
              <b>Sale this...</b>
            </Button>
          </div>
          <div>
            <h1>Edited lot</h1>
            <h2>{header}</h2>
            <p>{body}</p>
          </div>
        </div>
      )}
    </Container>
  );
};

export default CreateArt;
