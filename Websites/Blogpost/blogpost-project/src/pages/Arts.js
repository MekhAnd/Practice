import React from "react";
import { connect } from "react-redux";
import { NavLink } from "react-router-dom";
import { Container, Button } from "react-bootstrap";
import htmlParse from "html-react-parser";

import { fetchArts } from "../actions";
import { ALL_ART_ROUTE } from "../utils/consts";
import {
  langUA_Updated,
  langUA_UpdatedAgo,
  langUA_Look,
} from "../utils/languagesUA";
import {
  langENG_Look,
  langENG_Updated,
  langENG_UpdatedAgo,
} from "../utils/languagesENG";

class Arts extends React.Component {
  constructor(props) {
    super(props);
    this.state = null;
  }

  componentDidMount() {
    this.setState(this.props.fetchArts());
  }

  renderList = function () {
    const artsArray = this.props.arts;
    const url = "http://localhost:8000/";
    return artsArray.map((art, index) => {
      const period = Date.now() - Date.parse(art.updatedAt);
      const hours = Math.round(period / 1000 / 60 / 60);
      const days = Math.round(hours / 24);

      return (
        <div
          key={art.id}
          className="m-2 flex-column "
          style={{
            width: "48%",
            display: "inline",
          }}
        >
          <div className="card mb-2">
            <div
              style={{
                width: "100%",
                height: "400px",
                background: "url(" + url + art.photo + ")",
                backgroundSize: "cover",
              }}
              className="card-img-top"
            >
              <div className="card-body_art">
                <h2
                  style={{ textShadow: "2px 2px 2px #CECECE" }}
                  className="card-title"
                >
                  {htmlParse(art.header)}
                </h2>
                <div className="card-body_art__price-disc">
                  <div className="card-text">
                    {/* {art.body.length <= 600
                      ? htmlParse(art.body)
                      : htmlParse(art.body.substring(0, 300))} */}
                    <br></br>
                  </div>
                  <div
                    style={{ textShadow: "2px 2px 2px #CECECE" }}
                    className="price-disc"
                  >{`${art.price} UAH`}</div>
                </div>
                <div className="card-text blogs__bottom-container">
                  <div
                    style={{ textShadow: "2px 2px 2px #CECECE" }}
                    className="text-muted"
                  >
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
                  <NavLink
                    to={{
                      pathname: `${ALL_ART_ROUTE}/${art.id}`,
                      state: {
                        id: art.id,
                        header: art.header,
                        body: art.body,
                        photo: art.photo,
                        price: art.price,
                        updatedAt: art.updatedAt,
                        video: art.video,
                      },
                    }}
                  >
                    <Button
                      className="button-icon_look-art"
                      variant="dark"
                      size="lg"
                    >
                      {this.props.language === "ENG"
                        ? langENG_Look
                        : langUA_Look}
                    </Button>
                  </NavLink>
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
      <Container
        className="d-flex flex-lg-row flex-wrap"
        style={{ minHeight: "calc(100vh - 65px)" }}
      >
        {this.renderList()}
      </Container>
    );
  }
}
const mapStateToProps = (state) => {
  return { arts: state.arts, language: state.language };
};

export default connect(mapStateToProps, { fetchArts })(Arts);
//className="button-icon_eye outline-dark"
