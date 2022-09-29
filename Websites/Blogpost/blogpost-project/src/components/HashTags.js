import React from "react";
import { Container } from "react-bootstrap";
import { connect } from "react-redux";

import "../components/style/App.css";
import { fetchTags } from "../actions";
import { NavLink } from "react-router-dom";
import { HASH_BLOG_ROUTE } from "../utils/consts";

class HashTags extends React.Component {
  constructor(props) {
    super(props);
  }

  componentDidMount() {
    this.setState({ tagsArray: this.props.fetchTags() });
    console.log(this.props);
  }

  renderTags() {
    const tagsArray = this.props.tags;
    console.log(this.props);
    console.log(tagsArray);
    return tagsArray.map((tag) => {
      return (
        <div key={tag.id}>
          <NavLink
            to={{
              pathname: `${HASH_BLOG_ROUTE}/${tag.id}`,
              state: {
                tagID:tag.id
                },
            }}
            className="m-1 px-1 border border-dark rounded-start rounded-end"
            style={{
              background: `white`, //#${Math.floor(Math.random()*16777215).toString(16)}
              border: "black, solid, 1px",
              textDecoration: "none",
              color: "black",
              justifyContent: "safe",
              justifyItems: "middle",
            }}
          >
            {tag.name}
          </NavLink>
        </div>
      );
    });
  }
  render() {
    return (
      <div
        className="d-flex align-content-start flex-wrap hashtags"
        style={{
          width: "30%",
          justifyContent: "center",
          justifyItems: "middle",
          marginTop: "60px",
        }}
      >
        {this.renderTags()}
      </div>
    );
  }
}
const mapStateToProps = (state) => {
  return { tags: state.tags };
};
export default connect(mapStateToProps, { fetchTags })(HashTags);
