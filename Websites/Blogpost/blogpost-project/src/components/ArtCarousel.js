import React from "react";
import { connect } from "react-redux";
import htmlPars from "html-react-parser";
import { NavLink } from "react-router-dom";

import { fetchArts } from "../actions";
import "./style/ArtCarousel.css";
import { Container, Button } from "react-bootstrap";
import { ALL_ART_ROUTE } from "../utils/consts";

class ArtCarousel extends React.Component {
  constructor(props) {
    super(props);
    this.state = this.props;
    this.state = { index: 0 };
  }

  componentDidMount() {
    this.setState(this.props.fetchArts());
    this.setState({
      index: 0,
      min: 0,
      middle: 1,
      max: 2,
    });
  }

  componentDidUpdate(prevState, prevProps) {

    const artsArrary = this.props.arts;

    if (prevProps.index !== this.state.index) {
      if (this.state.index === 1) {
        if (this.state.max === artsArrary.length-1) {
          this.setState({
            min: this.state.min + this.state.index,
            middle: this.state.middle + this.state.index,
            max: 0,
          });
          this.setState({ index: 0 });
        } else if (this.state.middle === artsArrary.length-1) {
          this.setState({
            min: this.state.min + this.state.index,
            middle: 0,
            max: this.state.max + this.state.index,
          });
          this.setState({ index: 0 });
        } else if (this.state.min === artsArrary.length-1) {
          this.setState({
            min: 0,
            middle: this.state.middle + this.state.index,
            max: this.state.max + this.state.index,
          });
          this.setState({ index: 0 });
        } else {
          this.setState({
            min: this.state.min + this.state.index,
            middle: this.state.middle + this.state.index,
            max: this.state.max + this.state.index,
          });
          this.setState({ index: 0 });
        }
      } else if (this.state.index === -1) {
        if (this.state.max === 0) {
          this.setState({
            min: this.state.min + this.state.index,
            middle: this.state.middle + this.state.index,
            max: artsArrary.length-1,
          });
          this.setState({ index: 0 });
        } else if (this.state.middle === 0) {
          this.setState({
            min: this.state.min + this.state.index,
            middle: artsArrary.length-1,
            max: this.state.max + this.state.index,
          });
          this.setState({ index: 0 });
        } else if (this.state.min === 0) {
          this.setState({
            min: artsArrary.length-1,
            middle: this.state.middle + this.state.index,
            max: this.state.max + this.state.index,
          });
          this.setState({ index: 0 });
        } else {
          this.setState({
            min: this.state.min + this.state.index,
            middle: this.state.middle + this.state.index,
            max: this.state.max + this.state.index,
          });
          this.setState({ index: 0 });
        }
      }
    }

    this.render();
  }

  handleIndex(event) {
    const next = event.target.classList.value;
    if (next === "arrow_right") {
      this.setState({ index: 1 });
    } else {
      this.setState({ index: -1 });
    }
  }

  renderArts = () => {
    const url = "http://localhost:8000/";
    const artsArrary = this.props.arts;
    let resArray = [];

    for (let i = 0; i < artsArrary.length; i++) {
      if (i === this.state.min) {
        resArray[0] = artsArrary[i];
      } else if (i === this.state.middle) {
        resArray[1] = artsArrary[i];
      } else if (i === this.state.max) {
        resArray[2] = artsArrary[i];
      } else {
        continue;
      }
    }
    
    return resArray.map((art) => {
      return (
        <div key={art.id}>
          <NavLink
            style={{ textDecoration: "none", color: "white" }}
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
            <Container>
              <div className="carousel_main m-3 mb-0">
                <div
                  style={{
                    width: "250px",
                    height: "450px",
                    background: "url(" + url + art.photo + ")",
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                  }}
                  className="carousel_main__card-img m-3"
                ></div>
                <div className="carousel_main__card-info m-3">
                  <h3 className="m-3">{htmlPars(art.header).toUpperCase()}</h3>
                  <p className="carousel_main-price m-3">{art.price}UAH</p>
                </div>
              </div>
            </Container>
          </NavLink>
        </div>
      );
    });
  };

  render() {
    return (
      <div className="carousel">
        <button
          type="button"
          className="button-icon_carousel"
          onClick={(event) => this.handleIndex(event)}
        >
          <div className="arrow_left"></div>
        </button>
        {this.renderArts()}
        <button
          type="button"
          className="button-icon_carousel"
          onClick={(event) => this.handleIndex(event)}
        >
          <div className="arrow_right"></div>
        </button>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return { arts: state.arts };
};

export default connect(mapStateToProps, { fetchArts })(ArtCarousel);
