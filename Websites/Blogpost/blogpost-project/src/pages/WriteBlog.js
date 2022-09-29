import React, { useState } from "react";
import ReactQuill from "react-quill";
import "react-quill/dist/quill.snow.css";
import { useDispatch } from "react-redux";
import { Container, Button } from "react-bootstrap";

import { postBlog } from "../actions";
import { Redirect } from "react-router-dom";
import { ALL_BLOG_ROUTE } from "../utils/consts";
import { forEach } from "lodash";

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

const WriteBlog = () => {
  const [body, setBody] = useState("");
  const [header, setHeader] = useState("");
  const [cover, setCover] = useState();
  const [sent, setStatus] = useState(false);
  const dispatch = useDispatch();

  const createEntry = () => {
    const formData = new FormData();
    formData.append("header", header);
    formData.append("body", body);
    formData.append("photo", cover);
    formData.append("hashtag", null);
    dispatch(postBlog(formData));
    setStatus(true);
  };

  return (
    <Container className="mt-5" style={{ minHeight:"calc(100vh - 65px)"}}>
      {sent ? (
        <Redirect to={ALL_BLOG_ROUTE} />
      ) : (
        <div>
          <input
            className="form-control input-group"
            type="text"
            placeholder="It`s will be header for your next blog..."
            value={header}
            onChange={(event) => setHeader(event.target.value)}
          />

          <div className="form-control mb-2 mt-2 flex-row">
            <label
              className="form-control label p-2 bd-highlight"
              htmlFor="customFileLang"
            >
              <b>Choose a cover photo here...</b>
            </label>
            <input
              type="file"
              className="form-control p-2 bd-highlight"
              id="customFileLang"
              onChange={(e) => setCover(e.target.files[0])}
            />
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
              <b>Propagate this...</b>
            </Button>
          </div>
          <div>
            <h1>Edited post</h1>
            <h2>{header}</h2>
            <p>{body}</p>
          </div>
        </div>
      )}
    </Container>
  );
};

export default WriteBlog;
