import { combineReducers } from 'redux';

//Importing the function and naming it as 'BooksReducer'
import BooksReducer from './reducer_books';
import ActiveBook from './reducer_active_book';

//This is the mapping of our state. We're actually specifying what the state is in here.
//Ex: there is a piece of state right now called 'books' whose value is whatever is in 'BooksReducer'

const rootReducer = combineReducers({

  //This is equivalent to books: [ {title: 'Javascript'}, { title: 'Harry Potter' } ]
  books: BooksReducer,
  activeBook: ActiveBook

});

export default rootReducer;
