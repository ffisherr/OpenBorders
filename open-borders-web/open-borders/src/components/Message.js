import React, { Component } from 'react';


class Message extends Component {
    render() {
        return (
            <div className="message">
                <p>{this.props.sender} : {this.props.message}</p>
            </div>
        );
    }
}

export default Message;
