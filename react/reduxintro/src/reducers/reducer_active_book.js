
//State argument is not application state, only the PIECE of the state this reducer is reponsible for - one part of the state stored in Redux

//All reducers get two arguments: the current state, and our action
// Called whenever an action is dispatched by our app

//State is by default set to null if there is no value in it when the this method is called
//  Ex: User just boots up the app 
export default function(state = null, action) {
    
    switch(action.type) {
        case 'BOOK_SELECTED':

            //Only return fresh objects.
            // Don't mutate the state in between here before returning it.
            // i.e. 
            //  DO NOT: state.title = book.title; return state; 
            return action.payload;
    }
 
    //Adding a base case to return the state as it is if it's something that we don't care about
    //  Ex: If action is NOT of type 'BOOK_SELECTED'
    //    OR If user boots app up and they haven't chosen any active book yet (in this case we also set 'state' to null by default so that it is NOT UNDEFINED (we get an error for this))
    return state;
}