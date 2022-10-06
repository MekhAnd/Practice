import React from "react";
import { connect } from "react-redux";
import { Container } from "react-bootstrap";
import htmlParse from "html-react-parser";
import { ALL_BLOG_ROUTE } from "../utils/consts";
import { Redirect } from "react-router-dom/cjs/react-router-dom.min";

import "../components/style/WriteBlog.css";
import {
  check,
  login,
  deleteBlog,
  addHashTag,
  connectHashTag,
} from "../actions";
import Comment from "../pages/Comment";
import AddComment from "../components/AddComment";
import { Button } from "bootstrap";
import EditComponent from "../components/EditComponent";
import { clear } from "@testing-library/user-event/dist/clear";
import {  langUA_DeleteThis, langUA_EditThis, langUA_HashTag, langUA_Updated, langUA_UpdatedAgo } from "../utils/languagesUA";
import { langENG_DeleteThis, langENG_EditThis, langENG_HashTag, langENG_Updated, langENG_UpdatedAgo } from "../utils/languagesENG";


class ReadBlog extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ...this.state,
      post: this.props.location.state,
      comments: "",
      role: "",
      user: null,
      display: "none",
      updatedPost: {
        header: null,
        body: null,
      },
      status: false,
    };
    //RELOAD REACTION

    var perfEntries = performance.getEntriesByType("navigation");
    if (perfEntries && perfEntries.length > 0) {
      if (perfEntries[0].type === "reload") {
        check().then((data) => {
          if (data.role === "AUTHOR") {
            this.setState({
              ...this.state,
              user: data,
              role: "AUTHOR",
              isAuth: true,
            });
          } else if (data.role === "ADMIN") {
            this.setState({
              ...this.state,
              user: data,
              role: "ADMIN",
              isAuth: true,
            });
          } else {
            this.setState({
              ...this.state,
              user: data,
              role: "READER",
              isAuth: true,
            });
          }
        });
      }
    }
  }

  componentDidMount() {
    check().then((data) => {
      if (data.role === "AUTHOR") {
        this.setState({
          ...this.state,
          user: data,
          role: "AUTHOR",
          isAuth: true,
        });
      } else if (data.role === "ADMIN") {
        this.setState({
          ...this.state,
          user: data,
          role: "ADMIN",
          isAuth: true,
        });
      } else {
        this.setState({
          ...this.state,
          user: data,
          role: "READER",
          isAuth: true,
        });
      }
    });
    
  }

  deletePost() {
    console.log("Delete this");
    let id = this.state.post.id;
    this.props.deleteBlog(id);
    this.setState({ status: true });
  }

  createHashTagsRecord = () => {
    console.log(this.props);
    this.state.hashTagsArray.forEach((tag) => {
      this.props.addHashTag(tag, this.state.post.id);
      this.props.connectHashTag(tag, this.state.post.id);
      
      
    });
  };

  prepareHashTags = (e) => {
    const preHashTag = e.target.value.split(",");
    this.setState({ hashTagsArray: preHashTag });
  };

  render() {
    console.log("this.state", this.state);
    const url = "http://localhost:8000/";
    const period = Date.now() - Date.parse(this.state.post.updatedAt);
    const hours = Math.round(period / 1000 / 60 / 60);
    const days = Math.round(hours / 24);

    return (
      <Container style={{ minHeight: "calc(100vh - 65px)" }}>
        {this.state.status ? (
          <Redirect to={ALL_BLOG_ROUTE} />
        ) : (
          <div>
            <div key={this.state.post.id} className="m-5">
              <div className="card mb-3" style={{ border: "none" }}>
                <div
                  style={{
                    width: "100%",
                    height: "450px",
                    background: "url(" + url + this.state.post.photo + ")",
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                    backgroundRepeat: "no-repeat",
                    float: "right",
                  }}
                  className="card-img-left"
                >
                  <div style={{}}>
                    <h1
                      className="card-title m-4"
                      style={{
                        color: "red",
                        fontSize: "6em",
                        textShadow: "1px 1px 2px rgba(243,7,7,1)",
                      }}
                    >
                      {this.state.post.header.substring(0, 1)}
                      <span style={{ color: "black" }}>
                        {this.state.post.header.substring(1, 255)}
                      </span>
                    </h1>
                  </div>
                </div>

                <div className="card-body">
                  <div className="card-text" style={{ textAlign: "justify" }}>
                    {htmlParse(this.state.post.body)}
                  </div>
                  <br></br>
                  <div className="text-muted">
                    {" "}
                    <b>
                    {this.props.language === "ENG"? langENG_Updated:langUA_Updated}{" "}
                      {hours > 24 ? `${days} days` : `${hours} hours`} {this.props.language === "ENG"? langENG_UpdatedAgo:langUA_UpdatedAgo}{" "}{" "}
                    </b>
                  </div>
                  {this.state.role === "ADMIN" ||
                  this.state.role === "AUTHOR" ? (
                    <div>
                      <button
                        className="btn btn-lg btn-dark m-3"
                        type="button"
                        onClick={() => {
                          this.setState({ display: "flex" });
                        }}
                      >
                        {this.props.language === "ENG"? langENG_EditThis:langUA_EditThis}
                      </button>
                      <button
                        className="btn btn-lg btn-danger m-3"
                        type="button"
                        onClick={() => {
                          this.deletePost();
                        }}
                      >
                        {this.props.language === "ENG"? langENG_DeleteThis:langUA_DeleteThis}
                      </button>
                      <button
                        className="btn btn-lg btn-outline-light m-3"
                        type="button"
                        onClick={() => {
                          this.createHashTagsRecord();
                        }}
                      >
                        {this.props.language === "ENG"? langENG_HashTag:langUA_HashTag}
                      </button>

                      <div>
                        <input
                          type="text"
                          className="form-control mb-2 mt-2 p-2 bd-highlight"
                          placeholder="Input main words from text here. Divide this words by coma."
                          onChange={(e) => this.prepareHashTags(e)}
                        />
                      </div>
                    </div>
                  ) : (
                    <div></div>
                  )}
                  {this.state.display === "flex" && (
                    <EditComponent
                      className="blog-editing-element"
                      header={this.state.post.header}
                      body={this.state.post.body}
                      id={this.state.post.id}
                    />
                  )}
                </div>
              </div>
            </div>
            <div className="card flex-row m-5">
              {this.state.isAuth && (
                <AddComment
                  postID={this.state.post.id}
                  userID={this.state.userId}
                  entity={"blog"}
                />
              )}
            </div>
            <Comment blogId={this.state.post.id} entity={"blog"} />
          </div>
        )}
      </Container>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    userIsAuth: state.user.isAuth,
    deletedPost: state.deletedPost,
    hashTagID: state.hashTagID,
    hashTag: state.hashTag,
    language: state.language
  };
};

export default connect(mapStateToProps, {
  login,
  deleteBlog,
  addHashTag,
  connectHashTag,
})(ReadBlog);
