import React from "react";
import unsplash from "../api/unsplash";
import "./App.css";
import SearchBar from "./SearchBar";
import SearchResult from "./SearchResult";

class App extends React.Component {
  state = { images: [] };

   onSearchSubmit = async term => {

    const response = await unsplash.get("/search/photos", {
        params: { query: term },
        
      })
     
    this.setState( { images:response.data.results} )

  }

  render() {
    return (
      <div className="ui container" style={{ marginTop: "10px" }}>
        <SearchBar onSubmit={this.onSearchSubmit} />
        Found:  {this.state.images.length} images
        <SearchResult 
          imageList = { this.state.images }
          />
      </div>
    );
  }
}

export default App;
