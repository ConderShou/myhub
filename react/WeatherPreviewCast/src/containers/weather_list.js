import React, { Component } from 'react';
import { connect } from 'react-redux';
import SparkChart from '../components/chart';
import GoogleMap from '../components/google_map';

export class WeatherList extends Component {
    
    renderWeather(cityData) {

        const id = cityData.city.id;
        //Each element of array is passed into the map function as the variable 'weather'
        //We then access the temperature within each element of the array
        const temps = cityData.list.map(weather => weather.main.temp);

        //Optional conversion of tempratures can be done like this
        
        // const temps = _.map(cityData.list.map(weather => weather.main.temp), (temp) => temp - 273);

        const pressures = cityData.list.map(weather => weather.main.pressure);
        const humidities = cityData.list.map(weather => weather.main.humidity);

        //ES6 syntax

        //Get respective properties and name them like so

        // lon = cityData.city.coord.lon;
        // lat = cityData.city.coord.lat;

        const { lon, lat } = cityData.city.coord;

        return (

            // Remember that the key should be placed in the parent-most html of the array element
            <tr key={id}>
                <td><GoogleMap lon={lon} lat={lat} /></td>
                <td><SparkChart data={temps} color="orange" units="K"/></td>
                <td><SparkChart data={pressures} color="green" units="hPa" /></td>
                <td><SparkChart data={humidities} color="black" units="%"/></td>
            </tr>
            );
    }

    render() {
        return (
            <table className="table table-hover">
              <thead>
                <tr>
                    <th>City</th>
                    <th>Temperature (K)</th>
                    <th>Pressure (hPa)</th>
                    <th>Humidity (%)</th>
                </tr>
               </thead>
               <tbody>
                   {this.props.weather.map(this.renderWeather)}
               </tbody>
            </table>
            );
    }
}

// const weather = state.weather;
function mapStateToProps({ weather }) { 

    return { weather }; // { weather } === { weather: weather }
}

export default connect(mapStateToProps)(WeatherList);
