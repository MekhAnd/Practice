import React from "react";
import { connect } from "react-redux";
import { NavLink } from "react-router-dom";
import { Container, Button } from "react-bootstrap";
import htmlParse from "html-react-parser";

import { fetchBlogs, fetchComments } from "../actions";
import { ALL_BLOG_ROUTE } from "../utils/consts";
import HashTags from "./HashTags";
import { langUA_Continue, langUA_Updated, langUA_UpdatedAgo,} from "../utils/languagesUA"
import { langENG_Continue, langENG_Updated, langENG_UpdatedAgo } from "../utils/languagesENG"

class Blogs extends React.Component {
  constructor(props) {
    super(props);
    this.state = { language: this.props.language };
  }

  componentDidMount() {
    this.setState(this.props.fetchBlogs());
    console.log(this.state);
    console.log(this.props);
  }
  
  renderList = function () {
    
    console.log("renderList", this.props.language);
    const blogsArray = this.props.blogs;
    const url = "http://localhost:8000/";
    return blogsArray.map((blog, index) => {
      const period = Date.now() - Date.parse(blog.updatedAt);
      const hours = Math.round(period / 1000 / 60 / 60);
      const days = Math.round(hours / 24);
      if (index === 0) {
        return (
          <div
            key={blog.id}
            style={{
              width: "30%",
              display: "inline",
            }}
          >
            <div className="blog-container blogs_blog-container">
              <div
                style={{
                  display: "flex",
                  width: "400%",
                  height: "200px",
                  background: "url(" + url + blog.photo + ")",
                  backgroundSize: "containe",
                  backgroundRepeat: "no-repeat",
                  backgroundPosition: "center",
                }}
                className="card-img-top m-3"
              ></div>
              <div className="card-body">
                <div className="card-body_title-container">
                  <h2
                    className="card-title mt-2 mb-2"
                    style={{ color: "white" }}
                  >
                    {htmlParse(blog.header)}
                  </h2>
                  <div className=" mt-2 mb-2">{blog.date}</div>
                </div>
                <div
                  className="card-text blogs_blog-container-card-text text-justify"
                  style={{ textAlign: "justify" }}
                >
                  {blog.body.length <= 900
                    ? htmlParse(blog.body)
                    : htmlParse(blog.body.substring(0, 900))}
                  <span style={{ padding: "0px 5px" }}>&thinsp;</span>
                  <NavLink
                    style={{ textDecoration: "none", color: "white" }}
                    to={{
                      pathname: `${ALL_BLOG_ROUTE}/${blog.id}`,
                      state: {
                        id: blog.id,
                        header: blog.header,
                        body: blog.body,
                        photo: blog.photo,
                        updatedAt: blog.updatedAt,
                        video: blog.video,
                      },
                    }}
                  >
                    {this.props.language === "ENG"
                      ? langENG_Continue
                      : langUA_Continue}
                  </NavLink>
                  ...
                  <br></br>
                </div>
                <div className="card-text  blogs__bottom-container">
                  <div className="text-muted">
                    {" "}
                    <b>
                      {this.props.language === "ENG"
                        ? langENG_Updated
                        : langUA_Updated}{" "}
                      {hours > 24 ? `${days} days` : `${hours} hours`}{" "}
                      {this.props.language === "ENG"
                        ? langENG_UpdatedAgo
                        : langUA_UpdatedAgo}{" "}
                    </b>
                  </div>
                </div>
              </div>
            </div>
          </div>
        );
      } else {
        return;
      }
    });
  };

  render() {
    console.log("render", Date());
    console.log("render props.language", this.props.language);
    console.log("render state.language", this.state.language);
    const langENG_ReadMore = "Read more blogs...";
    const langUA_ReadMore = "Читати більше записів...";
    return (
      <div className="blogs_hashtags align-content-start flex-wrap row gx-5 mx-5" style={{ width: "98%" }}>
        <HashTags />
        <div style={{ width: "65%" }}>
          <div className="m-5">{this.renderList()}</div>
          <NavLink
            className="m-5"
            style={{ textDecoration: "none", color: "white", fontSize: "2em" }}
            to={{
              pathname: `${ALL_BLOG_ROUTE}`,
              state: {
                page: "main",
              },
            }}
          >
            {" "}
            {this.props.language === "ENG" ? langENG_ReadMore : langUA_ReadMore}
          </NavLink>
        </div>
      </div>
    );
  }
}
const mapStateToProps = (state) => {
  return {
    blogs: state.blogs,
    comments: state.comments,
    language: state.language,
  };
};

export default connect(mapStateToProps, {
  fetchBlogs: fetchBlogs,
  fetchComments,
})(Blogs);
