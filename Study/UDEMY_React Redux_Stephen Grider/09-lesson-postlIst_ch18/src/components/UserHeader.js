import React from "react";
import { connect } from "react-redux";

class UserHeader extends React.Component {
  render() {
    const { user } = this.props;
    if (!user) {
      return <div>Loading...</div>;
    }
    return <div className="header">{user.name}</div>;
  }
}

const mapStateToProps = (state, ownProps) => {
  console.log("ownProps", ownProps)
  console.log("state", state)
  return { user: state.users.find((user) => user.id === ownProps.userID) };
};
export default connect(mapStateToProps)(UserHeader);
