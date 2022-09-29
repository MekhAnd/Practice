import React from "react";
import { connect } from "react-redux";
import { Container } from "react-bootstrap";
import htmlParse from "html-react-parser"

import { fetchComments, deleteComment, check } from "../actions";
import { langUA_DeleteThis } from "../utils/languagesUA";
import { langENG_DeleteThis } from "../utils/languagesENG";

class Comments extends React.Component {
  constructor(props) {
    super(props);
    this.props = props;
    this.state = {
      comments: null,
      entity:this.props.entity
    };

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
    const id = this.props.blogId;
    const entity = this.props.entity
    this.setState(this.props.fetchComments(id, entity));
    console.log(this.props.language)
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

  componentDidUpdate(prevProps){
    
    if(this.props.comment !== prevProps.comment){
      console.log("Got it")
      const id = this.props.blogId;
      this.setState(this.props.fetchComments(id));
    }
  }

  deleteComment(id){
    console.log("Delete this")
    this.props.deleteComment(id)
  }

  renderComments = function () {
    const commentsArray = this.props.comments;
    return commentsArray.map((comment, index) => {
      {console.log(comment.approved)}
      if(comment.approved){
      return (
        <div key={comment.id} className="flex-row">
          <h2>{comment.alias}</h2>
          <div className="flex-column">
            <div>{comment.updatedAt}</div>
            <div>{htmlParse(comment.body)}</div>
            {this.state.role=== "AUTHOR" && <button
                className="btn btn-lg btn-danger m-3"
                type="button"
                onClick={() => {
                  this.deleteComment(comment.id);
                }}
              >
                {this.props.language === "ENG"? langENG_DeleteThis:langUA_DeleteThis}
            </button>}
          </div>
        </div>
      );}
    });
  };

  render() {
    return <Container>{(this.renderComments())}</Container>;
  }
}
const mapStateToProps = (state) => {
  return { comments: state.comments, comment:state.comment, delComment:state.delComment, user:state.user, language:state.language };
};
export default connect(mapStateToProps, { fetchComments, deleteComment})(Comments);

