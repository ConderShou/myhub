//NOTE: We can't reference information in ANY other file unless we import it. And likewise for files to this file
// This includes the React library itself!!
//  Yup, literally, have to import EVERYTHING you need


//Find the library in the node_modules folder named "react" and assign it to the VARIABLE React - THAT's why we can do "React.render", etc....

//Lodash throttles a function so it can be delayed in its calling

import _ from 'lodash';

import React, { Component } from 'react';  

//react-dom is used to manage the actual DOM, so we use that for rendering HTML components instead

import ReactDOM from 'react-dom';

import YTSearch from 'youtube-api-search'; 

//The "SearchBar" variable here will be EQUAL to the SearchBar component we are now exporting from 'search_bar.js'

import SearchBar from './components/search_bar'; 

import VideoList from './components/video_list';
import VideoDetail from './components/video_detail';

//Have to give relative path to files that WE make. NOT TRUE FOR LIBRARIES in npm_modules (hence the react import statements)
// Don't need the '.js' for .js files
 

//Youtube API key

const API_KEY = 'AIzaSyB2UPmU2uXXb7UbAMBDcgGi6QbuDFdXLzw';


class App extends Component {
	constructor(props) {
		super(props);

		//A property/variable named "videos" that will contain an array of videos (YTSearch returns an ARRAY OF OBJECTS)

		this.state = { 
			videos: [],
			selectedVideo: null
		 };

		//REMEMBER: We have to first INITIALIZE the state before changing it, that's why we change the state afterwards in the statement here
		//NOTE: YTSearch returns an ARRAY of OBJECTS - so we can just set the state to the returned response 'videos'

		this.videoSearch('surfboards');
	}

videoSearch(term) {
	YTSearch({ key: API_KEY, term: term}, (videos) => {

				//When the property is "videos" and we're setting it to "videos", we can just leave a singular "videos" and it'll mean the same thing
				// i.e. The bottom statement is equivalent to 'this.setState({ videos: videos })'' 

				 this.setState({ 
				 	videos: videos,
				 	selectedVideo: videos[0]
				 });
		});
}

	render() {

		// ===THROTTLING THE SEARCH BAR FUNCTION====
		//
		//Takes the inner function 'videoSearch' and returns a NEW function that does the same thing as the inner function BUT can only be called ONCE every 300 MILLISECONDS
		//
		//This is how GOOGLE INTANT SEARCH WORKS

		const videoSearch = _.debounce((term) => { this.videoSearch(term) }, 300)

		return (
			<div>
				<SearchBar onSearchTermChange={videoSearch} />
				
				{/* NOTE: We need the "state" of the parent component, the 'videos' array, into the VideoList for it to display

					To do so, we do "videos = {this.state.videos}"

					This is called PASSING 'PROPS'

				 'videos' is the  prop in this case - the variable that contains 'this.state.videos'

					'videos' will arrive in 'VideoList' as an ARGUMENT to its class in video_list.js 
						We call this 'props' as the input in the VideoList class to emphasize this ('props.videos' would refer to the videos prop passed in here within the TAG)

			 	*/}

			 	{/* 
							Because React tries to render immediately before the API call finishes, the array is empty at first. 

							So this means a video=undefined, or null prop is being passed

							As a result, make sure you have a check in place for VideoDetail that addresses this with a LOADING SCREEN
			 */}

			 	<VideoDetail video={this.state.selectedVideo} />

			 {/* 
						Crucial: If VideoList calls the function passed as 'onVideoSelect', the function will update the state of 'App', ITS PARENT COMPONENT

						VideoList can now call 'props.onVideoSelect'

			 */}
				<VideoList
				 onVideoSelect = {selectedVideo => this.setState({selectedVideo})}
				 videos={this.state.videos} />
			</div>
		);
	}
}


//You can use the "babeljs.io" site to see what the JSX code looks like as vanilla Javascript - very easy to get very messy!

// Take this component's generated HTML and put it on the page (in the DOM)
//React.render is ONLY available because we assigned the "react" library to the variable React


//NOTE: When we create a component, we are creating a CLASS of a component. So if we want to render it inside the HTML, we have to INSTANTIATE it like we would an object. This includes the 'App' variable - the function is a variable that produces INSTANCES of the component

//Read above at the notes on the function inside of 'App' to see why we need to use TAGS to INSTANTIATE it

//The second argument of this function is the location of the HTML element that we're trying to insert 'App' into
//   The root node that we usually insert our html into is the 'container' div, sometimes called 'app', etc...


ReactDOM.render(<App />, document.querySelector('.container'));

//This says, find an element with class "container", and render the 'App' component inside that div