import React from "react";
import { connect } from "react-redux";
import { postComment } from "../actions";
import { Container } from "react-bootstrap";
import { langUA_CommentThis } from "../utils/languagesUA"
import { langENG_CommentThis } from "../utils/languagesENG"


class AddComment extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            blogID: this.props.postID,
            artID:this.props.artID,
            value: "",
            entity: this.props.entity
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    handleChange(e){
        this.setState({
            ...this.state,
            value:e.target.value})
    }

    handleSubmit(e){
        const body = this.state.value
        const entity = this.state.entity
        if (entity === "blog") {
            this.props.postComment(body, this.state.blogID, null)
            this.setState({...this.state, value:''})    
        } else if (entity === "art"){
            this.props.postComment(body, null, this.state.artID)
            this.setState({...this.state, value:''})    
        }

        
    }

    render (){
        return (
            <Container>
                <div className="d-flex">
                    
                    <textarea className="m-2 p-2 form-control" 
                              id="textarea"
                              rows={2} 
                              cols={45}
                              value = {this.state.value}
                              onChange = {this.handleChange}
                              ></textarea>
                    <button
                        onClick={this.handleSubmit} 
                        className="w-25 m-2 btn btn-dark btn-lg btn-block"
                        
                        >{this.props.language === "ENG"? langENG_CommentThis:langUA_CommentThis}</button>
                </div>
            </Container>
        )
    }
}
const mapStateToProps = (state) => {
    return { comment: state.comment, language: state.language };
  };
  
  export default connect(mapStateToProps, { postComment })(AddComment)