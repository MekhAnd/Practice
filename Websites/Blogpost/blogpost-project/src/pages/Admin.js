import React from "react";
import { connect } from "react-redux";

import {
  fetchAudience,
  editUserInfo,
  check,
  fetchAllComments,
  matchingComment
} from "../actions";
import {  langUA_Approve, langUA_SaveThis } from "../utils/languagesUA";
import { langENG_Approve, langENG_SaveThis } from "../utils/languagesENG";

class Admin extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      audience: [],
      userRoleValue: "",
    };
    this.handleChangeRole = this.handleChangeRole.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    console.log(this.props);
    console.log(this.state);
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
        this.setState({ comments: this.props.fetchAllComments() });
      } else if (data.role === "ADMIN") {
        this.setState({
          ...this.state,
          user: data,
          role: "ADMIN",
          isAuth: true,
        });
        this.setState({ audience: this.props.fetchAudience() });
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


  handleChangeRole(e) {
    const newRole = e.target.value.toUpperCase();
    this.setState({
      ...this.state,
      userRoleValue: newRole,
    });
    
  }

  handleSubmit(userID) {
    const role = this.state.userRoleValue;
    const formData = new FormData();
    formData.append("id", userID);
    formData.append("role", role);

    this.props.editUserInfo(formData);
  }

  //   deleteUser(id){
  //     console.log(id)
  //     this.props.deleteUserAct(id)

  //   }

  renderCommentsList() {
    console.log(this.state.role);
    const commentsArray = this.props.comments;
    console.log(commentsArray);

    return commentsArray.map((comment) => {
      return (
        <tr key={comment.id}>
          <th className="flex-lg-row m-3" scope="row">
            {comment.id}
          </th>
          <td className="flex-lg-row m-3">{comment.alias}</td>
          <td className="flex-lg-row m-3">{comment.artId===null? "BLOG": "SHOP"}</td>
          <td className="flex-lg-row m-3">{comment.artId===null? comment.blogId:comment.artId}
            
          </td>
          <td className="flex-lg-row m-3">{comment.body}</td>
          <td className="flex-lg-column m-3">
            <button
              className="btn btn-sm btn-outline-secondary m-3"
              type="button"
              onClick={() => {
                this.props.matchingComment(comment.id);
              }}
            >
              {this.props.language === "ENG"? langENG_Approve:langUA_Approve}
            </button>
          </td>
        </tr>
      );
    });
  }

  renderUserList() {
    console.log(this.state.role);
    const usersArray = this.props.audience;
    console.log(this.props);

    return usersArray.map((user) => {
      return (
        <tr key={user.id}>
          <th className="flex-lg-row m-3" scope="row">
            {user.id}
          </th>
          <td className="flex-lg-row m-3">{user.alias}</td>
          <td className="flex-lg-row m-3">{user.email}</td>
          <td className="flex-lg-row m-3">
            <input
              className="mt-3"
              defaultValue={user.role}
              type="text"
              onChange={this.handleChangeRole}
            />
          </td>
          <td className="flex-lg-row m-3">{user.updatedAt}</td>
          <td className="flex-lg-column m-3">
            {/* <button
                className="btn btn-sm btn-danger m-3"
                type="button"
                onClick={() => {
                  this.deleteUser(user.id);
                }}
              >
                Delete this animal...
              </button> */}
            <button
              className="btn btn-sm btn-outline-secondary m-3"
              type="button"
              onClick={() => {
                this.handleSubmit(user.id);
              }}
            >
              {this.props.language === "ENG"? langENG_SaveThis:langUA_SaveThis}
            </button>
          </td>
        </tr>
      );
    });
  }

  render() {
    const role = this.state.role;
    return (
      <div>
        {role === "ADMIN" ? (
          <div
            className=" flex-wrap"
            style={{ minHeight: "calc(100vh - 65px)" }}
          >
            <table className="table table-dark">
              <thead>
                <tr>
                  <th scope="col">id</th>
                  <th scope="col">Alias</th>
                  <th scope="col">E-mail</th>
                  <th scope="col">Role</th>
                  <th scope="col">Registration date</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>{this.renderUserList()}</tbody>
            </table>
          </div>
        ) : (
          <div
            className=" flex-wrap"
            style={{ minHeight: "calc(100vh - 65px)" }}
          >
            <table className="table table-dark">
              <thead>
                <tr>
                  <th scope="col">id</th>
                  <th scope="col">Alias</th>
                  <th scope="col">Entity</th>
                  <th scope="col">ID</th>
                  <th scope="col">Comment</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>{this.renderCommentsList()}</tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  console.log(state);
  return { audience: state.audience, comments: state.comments, language:state.language };
};

export default connect(mapStateToProps, {
  fetchAudience,
  editUserInfo,
  fetchAllComments,
  matchingComment,
})(Admin);
