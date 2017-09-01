//This search bar should update the video list on the right hand side based on what we typed into the input
//	When user types something in, it should do a search of some sort

//Even though we're not calling a variable 'React' here, we should still import the library.
//		 We need the library to convert our JSX into JavaScript, whether we're explicitly using the 'React' variable or not

import React, { Component } from 'react';

//{ Component } IS THE SAME THING AS: 
//		const Component = React.Component;
// It means get 'React.Component' and name it as variable 'Component'

//If we can get the search bar component over into 'index.js', we can get index.js to show the HTML input element
//This is called a FUNCTIONAL COMPONENT - a component defined by a FUNCTION

	/*
		const SearchBar = () => {
			return <input />
		}	
	*/

//This is a CLASS COMPONENT. It's a REACT component due to the object inheritance of "React.Component" we just gave it
//	It's just 'Component' because of above declaration in braces: { Component }

//Do class components when you need ADDED FUNCTIONALITY

class SearchBar extends Component {

	//Initializing state in a class-based component
	//NOTE: only class-based components have state. NOT FUNCTIONAL COMPONENTS

	//Each instance of a class component has ITS OWN COPY of state

	//The constructor is the only function called automatically whenever a new instance of the class is created

	constructor(props) {

/*
	Whenever a component’s state is changed, the component immediately re-renders,
		and forces its children to re-render as well
*/

		//When we define a method already defined on the parent class, in this case 'Component'...we can call that parent method on the parent class, by calling "super"
		//		Therefore, the 'constructor' of the parent class is called here, because we called "super" inside the constructor method (we also gave it the same input parameters
		// YOU HAVE TO DO THIS - it'll throw an error and catch it for you if you don't
		super(props);

		//We created a new object 'term' and assigned it to 'this.state'
		//	  This object will have properties that we want to record on the state
		//		Here, we want to record the property 'term' (the search term) on 'state'
		//	We want to update the state with the VALUE of the input, and change 'term' to reflect that 

		//This is the only time we'll do anything with the state by setting "this.state" equal to something
		this.state = { term: '' };
	}


	//Must define a RENDER method for each REACT class
	// React will AUTOMATICALLY call this render function when it tries to render the SearchBar Component

	 render() {

	 	//All HTML elements emit a CHANGE event - this is VANILLA
	 	// 'onChange' references this event
	 	//This will call 'onInputChange' when the event occurs

	 	//We pass into it a 'prop', or property with a value of "this.onInputChange"
	 	// We use this {} whenever we're referencing a JavaScript variable inside JSX

	 	//After 'on', the following word usually describes what kind of event we're handling - in this case it's 'Change'

	 	//NOTE: This 'onChange' is a REACT-DEFINED property. Whenever the input receives some kind of change in keystroke, this event is called 

	 		/*
	 		return <input onChange={(event) => console.log(event.target.value)} />;
	 		*/

	 	//Now we are updating the state with 'this.setState'
	 	// NOT 'this.state.term = event.target.value' --- BAD!!

	 	/*
	 		return (
	 		 <div>
	 		 <input onChange={event => this.setState(
	 			{ term: event.target.value }
	 			) } />
	 		 </div>
	 		 );
	 	*/

	 	//IDEALLY: We want the 'input' to receive information FROM THE STATE, not the other way around

	 	//Input is now a CONTROLLED INPUT/FORM ELEMENT
	 	return (

	 		// RECOMMENDED: Set the highest level JSX element the className of the component, lowercase and separated by dashes when necessary

	 		 <div className="search-bar">
	 		 <input 

	 		 //IMPORTANT: When the state changes, the component is re-rendered, and the 'value' of the input (an HTML property) is now coming from the state

	 		 value = {this.state.term}

	 		 //Technically when this runs, the value of the input hasn't changed yet - not until it's RE-RENDERED, which happens immediately after

	 		 //The user is now ONLY changing the state. And the input only changes from the state now. 
	 		
	 		 
	 		 onChange={event => this.onInputChange(event.target.value)}/>
	 		 </div>
	 		 );   

	 }
	 	//Because it's just a single variable, we can also drop off the (). 
	 	//NOTE: this is in replacement of the 'this.onInputChange' function we previously included within the {}



	 //Event handler for handling input
	 // Naming convention: "on" or "handle" in beginning, followed by the action being handled

	 //Whenever we add an event handler, they're always called with an EVENT object - we can name it anything we want

	 //Event object has a lot of specific technical properties inside of it that describe the event that occurred

	 // onInputChange(event) {
	 // 		console.log(event.target.value);
	 // }

//REMEMBER: Whenever the input receives some kind of change in keystroke, the 'onChange' event is called 

	 onInputChange(term) {
	 	this.setState({ term: term });	

	 	// This means EVERY key stroke creates a new search. 
	 	// The search bar updates the website like google's search bar

	 	this.props.onSearchTermChange(term);
	 }
}



//To export a SPECIFIC part of the code here...
//	Now any file that IMPORTS the SearchBar Component, will now actually get the searchbar component

//EXPORT DOES NOT CHANGE FOR CLASS COMPONENTS

export default SearchBar;