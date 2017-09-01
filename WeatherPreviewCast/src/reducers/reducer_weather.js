//NOTE: By the time the promise reaches this reducer, it has already been resolved!

// When the ‘ReduxPromise’ middleware DETECTS that the PAYLOAD is a PROMISE, it STOPS the action, WAITS for it to be RESOLVED, and then creates a NEW action with the RESOLVED RESPONSE as the PAYLOAD

import { FETCH_WEATHER } from '../actions/index';  

//The weather data will be of multiple cities, so the state should be a null array where each element contains data on one city
export default function(state = [], action) {

    switch (action.type) {

        console.log('Action received: ', action);
        
        case FETCH_WEATHER:

            //Never mutate the state like:
            //  state.push(action.payload.data);

            //Now, we are returning a NEW instance of state that has the new information on the city added on to it
            
            //The bottom is nearly equivalent to the same statement below:
            //     return state.concat([action.payload.data]);
    
            // Take an array, put 'action.payload.data' inside of it
            // '...' means take all entries of the array 'state' and insert it into THIS array 
            //  Because '...state' is after the first element, it will insert the entries AFTER the first element
            return [ action.payload.data, ...state ];
    }
    return state;  
}