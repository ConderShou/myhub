import React from 'react';
import VideoListItem from './video_list_item';

const VideoList = (props) => {

	//Stay away from for loops as much as possible. Instead, try to use ITERATORS
	// 'array.map' is a good one to use instead
	//	This calls the function input inside 'map()' on EACH element of the array and RETURNS this new array

//React needs an ID for each list item otherwise it won’t know WHICH specific list item to update when it’s called to do so.

//It would have to re-render the ENTIRE list to make sure that that one specific list item was updated 

//In this case, we can use the ‘etag’ returned from the YTSearch API result, a unique tag for each video list item - as the key.
//		HENCE: key={video.etag}

	const videoItems = props.videos.map((video) => {
		return (
			<VideoListItem 

			//We're just passing the 'onVideoSelect' prop to VideoListItem

				onVideoSelect = {props.onVideoSelect}
				
				key={video.etag} 
				video = {video} />
		)
	});	

	// The below statement will equal the array of videos that YTSearch returns in the parent component index.js
	// const videos = props.videos;

	return (
		//We use 'className' to name the class of this HTML element (just like using 'class' but avoids any naming conflicts with defining a class component)

		//'col-md-4' is a BOOTSTRAP term for a 'medium column of width 4'


		<ul className = "col-md-4 list-group">

			{/* Even though this is just an ARRAY of components, React is smart and will try to render all the components AUTOMATICALLY */}

			{videoItems}

		</ul>
		);
};

export default VideoList;