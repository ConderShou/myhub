import React from 'react';

const VideoListItem = ({video, onVideoSelect}) => {

	//Normal javascript/programming stuff. Just getting the properties from the object in the array
	const imageURL = video.snippet.thumbnails.default.url;

	//Passed in as 'video' in video_list
	//const video = props.video;
	// This is EQUIVALENT to what we have IN PLACE OF 'props' right now (i.e. (props) => ...)
	//	Same thing for 'const onVideoSelect = props.onVideoSelect'

	return (

		//onClick is a javascript event handler
		
			<li onClick={() => onVideoSelect(video)} className = "list-group-item">
				<div className = "video-list media">
					<div className = "media-left">
						<img className="media-object" src={imageURL}/>
					</div>
				
				
					<div className="media-body">
						<div className="media-heading">{video.snippet.title}</div>
					</div>
				</div>
			</li>
	);

};

export default VideoListItem;