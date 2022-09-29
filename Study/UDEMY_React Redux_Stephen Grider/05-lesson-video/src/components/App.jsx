import React from "react";
import SearchBar from "./SearchBar";
import youtube from "../apis/youtube";
import ListVideo from "./ListVideo";
import VideoDetail from "./VideoDetail";

class App extends React.Component {
  state = { videos: [], selectedVideo: null };

  componentDidMount() {
    this.onTermSubmit('french buldog puppys')
  }

  onTermSubmit = async (term) => {
    const responce = await youtube.get("/search", {
      params: {
        q: term,
      },
    });

    this.setState({
      videos: responce.data.items,
      selectedVideo: responce.data.items[0],
    });
  };

  onVideoSelect = (video) => {
    console.log("from App", video);
    this.setState({ selectedVideo: video });
  };

  render() {
    return (
      <div className="ui container">
        <SearchBar onFormSubmit={this.onTermSubmit} />
        <div className="ui grid">
          <div className="ui row">
            <div className="eleven wide column">
              <VideoDetail video={this.state.selectedVideo} />
            </div>
            <div className="five wide column">
              <ListVideo
                videos={this.state.videos}
                onVideoSelect={this.onVideoSelect}
              />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default App;
