import React, { Component } from 'react';

class GoogleMap extends Component {


    //---- Intro to Integrating with Third Party Libraries---
    // ( more later )

    //Called immediately after the component has been rendered onto the screen

    //Google maps is going to take the div and render an embedded map into it
    componentDidMount() {
        new google.maps.Map(this.refs.map, {
            zoom: 12,
            center: {
                lat: this.props.lat,
                lng: this.props.lon
            }
        })
    }
    render() {

        //Now, anywhere in this component, I can refer to this HTML element with 'this.refs.map'
        return <div ref="map" />;
    }
}

export default GoogleMap;