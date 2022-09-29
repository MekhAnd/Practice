import React from "react";
import { connect } from "react-redux";
import { Container } from "react-bootstrap";
import htmlParse from "html-react-parser";

import "../components/style/App.css";
import { check, login, deleteArt } from "../actions";
import Comment from "../pages/Comment";
import AddComment from "../components/AddComment";
import EditComponent from "../components/EditComponent";
import { deletedArt } from "../redusers/addArtReduser";
import { Redirect } from "react-router-dom/cjs/react-router-dom";
import { ALL_ART_ROUTE } from "../utils/consts";
import { langUA_DeleteThis, langUA_EditThis, langUA_Updated, langUA_UpdatedAgo } from "../utils/languagesUA";
import { langENG_DeleteThis, langENG_EditThis, langENG_Updated, langENG_UpdatedAgo } from "../utils/languagesENG";

class Art extends React.Component {
  constructor(props) {
    super(props);
    console.log(this.props);
    this.state = {
      ...this.state,
      art: this.props.location.state,
      comments: "",
      role: "",
      user: null,
      status: false,
    };

    console.log(this.state);
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
              role: "AUTHOR",
              isAuth: true,
            });
          } else {
            this.setState({
              ...this.state,
              user: data,
              role: "AUTHOR",
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
          role: "AUTHOR",
          isAuth: true,
        });
      } else {
        this.setState({
          ...this.state,
          user: data,
          role: "AUTHOR",
          isAuth: true,
        });
      }
    });
  }

  deletePost() {
    let id = this.state.art.id;
    this.props.deleteArt(id);
    this.setState({ status: true });
  }

  render() {
    const url = "http://localhost:8000/";
    const period = Date.now() - Date.parse(this.state.art.updatedAt);
    const hours = Math.round(period / 1000 / 60 / 60);
    const days = Math.round(hours / 24);
    return (
      <Container style={{ minHeight: "calc(100vh - 65px)" }}>
        {this.state.status ? (
          <Redirect to={ALL_ART_ROUTE} />
        ) : (
          <div>
            <div key={this.state.art.id} className="m-5">
              <div className="card mb-3" style={{ border: "none" }}>
                <div
                  style={{
                    width: "100%",
                    height: "450px",
                    background: "url(" + url + this.state.art.photo + ")",
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                    backgroundRepeat: "no-repeat",
                    // float: "right",
                    display: "flex",
                    justifyContent: "space-evenly",
                  }}
                  className="card-img-left"
                >
                  <div
                    style={{
                      display: "flex",
                      flexDirection: "column",
                      justifyContent: "space-between",
                    }}
                  >
                    <h1
                      className="card-title m-4"
                      style={{
                        color: "red",
                        fontSize: "6em",
                        textShadow:"2px 2px 2px #CECECE",
                      }}
                    >
                      {this.state.art.header.substring(0, 1)}
                      <span style={{ color: "black" }}>
                        {this.state.art.header.substring(1, 255)}
                      </span>
                    </h1>
                    <div
                      className="art_price"
                      style={{
                        color: "white",
                        fontSize: "6em",
                        textShadow:"2px 2px 2px #CECECE",
                        textAlign: "right",
                      }}
                    >{`${this.state.art.price} UAH`}</div>
                  </div>
                </div>

                <div className="card-body">
                  <div className="card-text" style={{ textAlign: "justify" }}>
                    {htmlParse(this.state.art.body)}
                  </div>
                  <div className="card-text">
                    {this.state.role === "ADMIN" ||
                    this.state.role === "AUTHOR" ? (
                      <div>
                        {this.state.role === "AUTHOR" && (
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
                          </div>
                        )}
                      </div>
                    ) : (
                      <div></div>
                    )}
                    <div className="text-muted">
                      <b>
                      {this.props.language === "ENG"? langENG_Updated:langUA_Updated}{" "}
                        {hours > 24 ? `${days} days` : `${hours} hours`} {this.props.language === "ENG"? langENG_UpdatedAgo:langUA_UpdatedAgo}{" "}{" "}
                      </b>
                    </div>
                  </div>

                  {this.state.display === "flex" && (
                    <EditComponent
                      className="blog-editing-element"
                      header={this.state.art.header}
                      body={this.state.art.body}
                      price={this.state.art.price}
                      id={this.state.art.id}
                    />
                  )}
                </div>
              </div>
            </div>
            <div className="card flex-row m-5">
              {this.state.isAuth && (
                <AddComment
                  artID={this.state.art.id}
                  userID={this.state.userId}
                  entity={"art"}
                />
              )}
            </div>
            <Comment blogId={this.state.art.id} entity={"art"} />
          </div>
        )}
      </Container>
    );
  }
}

const mapStateToProps = (state) => {
  return { userIsAuth: state.user.isAuth, deletedArt: state.deletedArt, language:state.language };
};

export default connect(mapStateToProps, { login, deleteArt })(Art);
