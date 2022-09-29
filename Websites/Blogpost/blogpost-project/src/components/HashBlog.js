import React from "react";
import { connect } from "react-redux";
import htmlParse from "html-react-parser";
import { NavLink } from "react-router-dom";
import { Container, Button } from "react-bootstrap";

import { fetchTaggedBlogs } from "../actions";
import { ALL_BLOG_ROUTE } from "../utils/consts";
import { langUA_Continue, langUA_Updated, langUA_UpdatedAgo } from "../utils/languagesUA"
import { langENG_Continue, langENG_Updated, langENG_UpdatedAgo } from "../utils/languagesENG"

class HashBlog extends React.Component {
  constructor(props) {
    super(props);
    console.log(this.state)
    console.log(this.props)


  }

  componentDidMount() {
    console.log(this.props.match.params.id);
    const tag = this.props.match.params.id;
    this.setState(this.props.fetchTaggedBlogs(tag));
  }


  renderList = function () {
    // console.log("render");
    const blogsArray = this.props.taggedBlogs;
    const url = "http://localhost:8000/";
    return blogsArray.map((blog, index) => {
      const period = Date.now() - Date.parse(blog.updatedAt);
      const hours = Math.round(period / 1000 / 60 / 60);
      const days = Math.round(hours / 24);

      return (
        <div
          key={blog.id}
          style={{
            width: "48%",
            display: "inline",
          }}
        >
          <div className="blog-container">
            <div
              style={{
                width: "100%",
                height: "400px",
                background: "url(" + url + blog.photo + ")",
                backgroundSize: "cover",
                backgroundRepeat: "no-repeat",
                backgroundPosition: "center",
              }}
              className="card-img-top"
            ></div>
            <div className="card-body">
              <div className="card-body_title-container">
                <h2 className="card-title mt-5 mb-5" style={{ color: "white" }}>
                  {htmlParse(blog.header)}
                </h2>
                <div className=" mt-5 mb-5">{blog.date}</div>
              </div>
              <div className="card-text text-justify">
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
              <div className="card-text blogs__bottom-container">
                <div className="text-muted m-3">
                  {" "}
                  <b>
                  {this.props.language === "ENG"
                      ? langENG_Updated
                      : langUA_Updated}{" "}
                    {hours > 24 ? `${days} days` : `${hours} hours`} {this.props.language === "ENG"
                      ? langENG_UpdatedAgo
                      : langUA_UpdatedAgo}{" "}
                  </b>
                </div>
                
              </div>
            </div>
          </div>
        </div>
      );
    });
  };

  render() {
    return (
      <Container style={{ width: "65%", minHeight:"calc(100vh - 65px)"}}>
        <div className="m-5">{this.renderList()}</div>
      </Container>
    );
  }
}

const mapStateToProps = (state) => {
  return { taggedBlogs: state.taggedBlogs, language:state.language };
};

export default connect(mapStateToProps, { fetchTaggedBlogs })(HashBlog);
