import React, { useEffect, useState } from "react";
import SearchBar from "./SearchBar";
import youtube from "../apis/youtube";
import ListVideo from "./ListVideo";
import VideoDetail from "./VideoDetail";

const App = ()=>{

  const [selectedVideo, setSelectedVideo] = useState (null)

  // setSelectedVideo(responce.data.items[0])
  
    return (
      <div className="ui container">
        <SearchBar onFormSubmit={onTermSubmit} />
        <div className="ui grid">
          <div className="ui row">
            <div className="eleven wide column">
              <VideoDetail video={selectedVideo} />
            </div>
            <div className="five wide column">
              <ListVideo
                videos={videos}
                onVideoSelect={setSelectedVideo} //=== video=>{setSelectedVideo(video)}
              />
            </div>
          </div>
        </div>
      </div>
    );
}


export default App
