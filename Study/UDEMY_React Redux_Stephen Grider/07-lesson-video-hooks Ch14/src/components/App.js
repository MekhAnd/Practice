import React, { useEffect, useState } from "react";
import SearchBar from "./SearchBar";
import ListVideo from "./ListVideo";
import VideoDetail from "./VideoDetail";
import useVideos from "../hooks/useVideos";

const App = () => {
  const [selectedVideo, setSelectedVideo] = useState(null);
  const [videos, search] = useVideos("doberman");

  useEffect(() => {
    setSelectedVideo(videos[0]);
  }, [videos]);

  return (
    <div className="ui container">
      <SearchBar onFormSubmit={search} />
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
};

export default App;
