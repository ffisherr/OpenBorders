import React, { Component } from 'react';
import { Container, FormControl, Nav, Navbar, Form, Button} from 'react-bootstrap';
import { Switch, BrowserRouter as Router, Route, Link } from 'react-router-dom';


class Registration extends Component{
    render(){
        return(
            <Form>
                <Form.Group controlId="fromBasicEmail">
                    <Form.Label>Email Adress</Form.Label>
                    <Form.Control type="email" placeholder="Enter email"/>
                </Form.Group>
                <Form.Group controlId="fromBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Enter password"/>
                </Form.Group>
            </Form>
        )
    }
}

export default Registration;