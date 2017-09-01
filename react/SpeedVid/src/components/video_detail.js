import React from 'react';

const VideoDetail = ({video}) => {

	//When React immediately renders this component, it does so even when the array hasn't been filled by the API call yet, so we have to put a check for it as it loads


	if (!video) {
		return <div>Loading...</div>;
	}

	const videoID = video.id.videoId;

	//Interpolates the string with the javascript variable

	const url = `https://www.youtube.com/embed/${videoID}`;

	return (
		<div className="video-detail col-md-8">
			<div className="embed-responsive embed-responsive-16by9">

		{/* With iframes, the browser will go to the url in source and place the content of the url inside the iframe */}

				<iframe className="embed-responsive-item" src={url}> </iframe>
			</div>
			<div className="details">
				<div>{video.snippet.title}</div>
				<div>{video.snippet.description}</div>
			</div>
		</div>

		);

};

export default VideoDetail;