import React, { Component } from 'react';
import Message from './Message.js';

class Chat extends Component {

    state = {
        input: '',
        username: 'UnknownUser',
        messages: [],
    }

    componentDidMount() {
          fetch("http://localhost:8080/user/me/")
            .then(response => response.json())
            .then((response) =>{
                this.setState({username: response.userName});
            });
            this.getMessages();
      }
    
    getMessages() {
        fetch("http://localhost:8080/messages")
          .then(res => res.json())
          .then(
            (result) => {
              this.setState({
                messages: result.content
              });
            },
            // Примечание: важно обрабатывать ошибки именно здесь, а не в блоке catch(),
            // чтобы не перехватывать исключения из ошибок в самих компонентах.
            (error) => {
                console.log(error);
                this.setState({
                    messages: [],
                });
            }
          );
      }

    handleChange(e) {
        this.setState( {
            input: e.target.value,
            messages: this.state.messages,
        });
    }

    handleClick(e) {
        console.log('Sending: ' + this.state.input);
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ message: this.state.input })
        };
        fetch('http://localhost:8080/messages/', requestOptions)
            .then(response => response.json())
            .then((response) => this.setState({ messages: response.content }));
    }

    render() {
        return (
            <div className="chat">
                {this.state.messages.map(message => (
                    <Message key={message.id} sender={message.isFromUser ? this.state.username : "Бот"} message={message.message} />
                ))}
                <input type="text" onChange={ this.handleChange.bind(this) } />
                <button className="square" onClick={ this.handleClick.bind(this) }>
                    Send
                </button>
            </div>
        ); 
    }
}

export default Chat;
