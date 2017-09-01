/* In order to create a bridge between the redux library and the react library: 
    - We need to use 'react-redux' library
    - We need to promote a Component into a CONTAINER

 The container = React component that has a DIRECT connection to the state managed by redux


 This is a container. Or AKA a 'Smart Component'


 ---Which apps should be containers?----

 The most parent component that cares about a particular piece of state should be a container.

 By "caring" we mean, DIRECTLY USING that piece of state.

    The easy way out: Connecting App.js to Redux as a container and VOILA all of our components are connected to redux. BUT THAT IS NOT GOOD PROGRAMMING PARADIGM.
        - OOP
        - Modularization

 This also means that: 
     The children components of BookList (if they existed) WOULD NOT BE CONTAINERS
*/

import React, { Component } from 'react';

//Remember that with curly braces, we're just pulling out a PROPERTY OF the object that is being exported from 'react-redux'
// Rather than the whole object itself
import { connect } from 'react-redux';

import { selectBook } from '../actions/index';

// This makes sure that our action and its result actually flows through all the reducers in our application

import { bindActionCreators } from 'redux';

//Removed: export default, we want to export the CONTAINER not the 'dumb' component part of this file
class BookList extends Component {
    
    renderList() {
        return this.props.books.map((book) => {
            return (

                //Remember that we need to provide a key when it comes to rendering a list 

                //Just insert whatever you think will be unique for each item

                //After wiring the action up, we can now use onClick to call it knowing that it should affect the reducers
                <li 
                key={book.title}
                onClick={() => this.props.selectBook(book)} 
                className="list-group-item"
                >
                    {book.title}
                </li>
                )
        })
    }

    render() {
        return (
            <ul className="list-group col-sm-4">
                {this.renderList()}
            </ul>
        )
    }
}

//Takes our APPLICATION'S state as an argument
// Application state = state stored in redux

//NOTE: Whenever our APPLICATION STATE CHANGES (loading a list of books from a server), this container will AUTOMATICALLY RE-RENDER with the NEW LIST OF BOOKS


function mapStateToProps(state) {
    // Whatever is returned from here will be set as 'this.props' in our component

    return {

        //The key 'books' is what the property will be called in props => this.props.books

        //    Ex: asdf: '123' ==> 'this.props.asdf' will equal '123'
        books: state.books
    };
}


//Anything returned from this function will end up as props on the Booklist container

//'selectBook' - the KEY - is now on our props, we can call 'this.props.selectBook'
function mapDispatchToProps(dispatch) {
    //Whenever 'selectBook' is called within this component, the result is passed to all of our reducers

    //The VALUE 'selectBook' is what we imported at the top

    //'dispatch' is a function that sends it to all our reducers
    return bindActionCreators({ selectBook: selectBook }, dispatch)
}

//Exporting the CONTAINER
// ------Connect-------
/*
    Connect takes in a function and a component and PRODUCES A CONTAINER (a component that is aware of the state within redux)

    Now it also knows about 'selectBook', the dispatch method, and makes it available as a prop to this component

    REFER TO 'REACT-REDUX' documentation for more ways to use 'connect' - This is the most widely used container
*/
export default connect(mapStateToProps, mapDispatchToProps)(BookList);



