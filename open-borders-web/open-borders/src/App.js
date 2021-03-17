import React, { Component } from 'react';
import Chat from './components/Chat.js';
import Registration from './components/Registration.js';
import './App.css';
import Input from './components/Input.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.css';
import Login from './components/Login.js';

class App extends Component {
  render() {
    return (
        <Login />
      );
  }
}

export default App;
