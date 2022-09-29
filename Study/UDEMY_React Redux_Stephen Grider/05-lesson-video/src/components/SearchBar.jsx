import React from "react";

class SearchBar extends React.Component {
  state = { term: "" };

  onInputChange = (e) => {
    this.setState({ term: e.target.value });
  };

  onFormSubmit = (e) =>{
    e.preventDefault();

    this.props.onFormSubmit(this.state.term)
  }


  render() {
    return (
      <div className="search-bar ui segment">
        <form 
            onSubmit={this.onFormSubmit}
            action="" className="ui form">
          <div className="field">
            <input
              type="text"
              placeholder="Do you want to see something?"
              value={this.state.term}
              onChange={this.onInputChange}
            />
          </div>
        </form>
      </div>
    );
  }
}

export default SearchBar;
