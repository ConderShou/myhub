import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { fetchWeather } from '../actions/index';


export class SearchBar extends Component {

    constructor(props) {
        super(props);

        this.state = { term: '' };

        //Now 'this' will refer to the correct context

        //RIGHT SIDE (RH): 
        //    'this' (the component) has a function called 'onInputChange'
        //    Bind that function to the current context of 'this'
        //LEFT SIDE (LH):
        //    Replace the current 'this.onInputChange' function with the BOUND instance of 'this.onInputChange' from the RH
        this.onInputChange = this.onInputChange.bind(this);
        this.onFormSubmit = this.onFormSubmit.bind(this);
    }
 
    onInputChange(event) {
        this.setState({
            term: event.target.value
        });
    }

    onFormSubmit(event) {

        //This tells browser to NOT submit the form with a POST request to the backend as it does on a default submit
        event.preventDefault();

        //Now we can go ahead and do what we actually want to do on a submit - like getting weather data
        this.props.fetchWeather(this.state.term);
        this.setState({ term: '' });

    }
    
    render() {
        return (
            <form onSubmit={this.onFormSubmit} className="input-group">
                <input 
                    placeholder="Get a five day forecast in your favorite cities"
                    className="form-control"
                    value={this.state.term}

                    //Whenever we use a callback function or handler, 'this' will refer to some mystery context if we don't use the ARROW FUNCTION syntax

                    //Instead of doing:
                    //    'onChange={() => onInputChange()' like last time, we're going to BIND it to the right context
                    onChange={this.onInputChange}
                />
                <span className="input-group-btn">
                    <button type="submit" className="btn btn-secondary">
                    Submit 
                    </button>
                </span>
            </form>
            );
    }
}

function mapDispatchToProps(dispatch) {

    //This is the same thing as passing in '{ fetchWeather: fetchWeather }'
    return bindActionCreators({ fetchWeather }, dispatch);
}

//We don't have a need for 'mapStateToProps' so instead of passing that function, we pass 'null'
export default connect(null, mapDispatchToProps)(SearchBar);

