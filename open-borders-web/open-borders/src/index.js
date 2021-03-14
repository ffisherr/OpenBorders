import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Form from './components/Form' 
import Login from './components/Login' 


const inputs = [{
  name: "username",
  placeholder: "username",
  type: "text"
},{
  name: "password",
  placeholder: "password",
  type: "password"
},{
  type: "submit",
  value: "Submit",
  className: "btn" 
}]

const props = {
  name: 'loginForm',
  method: 'POST',
  action: '/perform_login',
  inputs: inputs
}

const params = new URLSearchParams(window.location.search)

ReactDOM.render(
  <React.StrictMode>
    <Login/>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
