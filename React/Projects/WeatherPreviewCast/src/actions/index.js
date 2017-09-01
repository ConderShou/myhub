import axios from 'axios';

const API_KEY = 'eacc07830fd7d628994f5254d19ba01d';
const ROOT_URL = `http://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;

//Exporting this as a variable ENSURES consistency and easy adjustment when needed
export const FETCH_WEATHER = 'FETCH_WEATHER';

export function fetchWeather(city) {

    //For query fragments, it does not mbatter which order they come in as long as they are enjoined by &
    const url = `${ROOT_URL}&q=${city},us`;

    //This returns a promise 

    //NOTE: By the time the promise reaches this reducer, it has already been resolved!

// When the ‘ReduxPromise’ middleware DETECTS that the PAYLOAD is a PROMISE, it STOPS the action, WAITS for it to be RESOLVED, and then creates a NEW action with the RESOLVED RESPONSE as the PAYLOAD
    const request = axios.get(url);


    return ({
        type: FETCH_WEATHER,
        payload: request
        });
}