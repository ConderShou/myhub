//This is the highest order component that cares specifically about what the active book is - therefore we make this a container

import React, { Component } from 'react';
import { connect } from 'react-redux';


class BookDetail extends Component {
    render() {


        //NOTE: activeBook is NULL when the application first boots
        if (!this.props.book) {
            return (
                <div>Select a book to get started.</div>
                );
        }


        return (
            <div>
                <h3>Details for: </h3>
                <div>Title: {this.props.book.title}</div>
                <div>Pages: {this.props.book.pages}</div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        //Value 'state.activeBook' specified in the redux state (reducers/index.js)

        //NOTE: activeBook is NULL when the application first boots, we address at the top in the render() method
        book: state.activeBook
    };
}

export default connect(mapStateToProps)(BookDetail);