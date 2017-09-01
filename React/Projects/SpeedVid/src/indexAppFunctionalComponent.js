//NOTE: We can't reference information in ANY other file unless we import it. And likewise for files to this file
// This includes the React library itself!!
//  Yup, literally, have to import EVERYTHING you need


//Find the library in the node_modules folder named "react" and assign it to the VARIABLE React - THAT's why we can do "React.render", etc....

import React from 'react';  

//react-dom is used to manage the actual DOM, so we use that for rendering HTML components instead

import ReactDOM from 'react-dom';

import YTSearch from 'youtube-api-search'; 

//The "SearchBar" variable here will be EQUAL to the SearchBar component we are now exporting from 'search_bar.js'

import SearchBar from './components/search_bar'; 

//Have to give relative path to files that WE make. NOT TRUE FOR LIBRARIES in npm_modules (hence the react import statements)
// Don't need the '.js' for .js files
 

//Youtube API key

const API_KEY = 'AIzaSyB2UPmU2uXXb7UbAMBDcgGi6QbuDFdXLzw';


YTSearch({ key: API_KEY, term: 'surfboards'}, function(data) {
	console.log(data);
})





//Create a new component. This component should produce HTML

//Constant variable assigned a function that returns JSX (what looks like HTML but is behind the scenes, really just Javascript)

//This App is a CLASS not an instance

const App = () => {

	//<div></div> actually calls "React.createElement("div", null)"
	// 'div' is actually a component CLASS, but using it inside JSX makes it into a component 
	//		THEREFORE <App></App> will also create an INSTANCE of App
	//		NOTE: Tags without anything inside of it can be written as self-closing. <App /> (This is a JSX quality) 

	//Parenthese are optional for multi-line statements. They're nice to organize with
	return (
		<div>
			<SearchBar />
		</div>
		);  

	//Babel translates this JSX into vanilla Javascript that can be interpreted inside the browser and produce the typed HTML
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