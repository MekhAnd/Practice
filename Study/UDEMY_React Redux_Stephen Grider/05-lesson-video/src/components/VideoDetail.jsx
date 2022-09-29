import React from "react";

function VideoDetail({ video }) {
  if (!video) {
    return <div>Lodaing...</div>;
  }
  const src = "https://www.youtube.com/embed/" + video.id.videoId;
  return (
    <div>
      <div className="ui embed">
        <iframe
          src={src}
          title="YouTube video player"
          frameBorder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowFullScreen
        ></iframe>
      </div>
      <div className="ui segment">
        <h4>{video.snippet.title}</h4>
        <p>{video.snippet.description}</p>
      </div>
    </div>
  );
}

export default VideoDetail;
