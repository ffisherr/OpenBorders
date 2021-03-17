import React, {Component} from 'react';
import {Navbar, Nav, Button, Container, Modal, Form} from 'react-bootstrap';
import { Switch, BrowserRouter as Router, Route, Link } from 'react-router-dom';

import Registration from './Registration';

class Login extends Component {


        handleShow () {
            window.location.assign('http://localhost:3001/registration');
            console.log('Открываем окно');
        }

        render() {
        return(
            <>

            <Form>
                <Form.Group controlId="formBasicUsername">
                    <Form.Label>Username</Form.Label>
                    <Form.Control type="username" placeholder="Username" />
                </Form.Group>
          
                <Form.Group controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" />
                </Form.Group>

                <Button variant="primary" type="Input" className="mr-3">
                    Input   
                </Button>

                <Button variant="primary" type="Registration"className="mr-3" onClick={this.handleShow.bind(this)}>
                    Registration
                </Button>
                
                <Button variant="primary" type="PasswordRecovery">
                    PasswordRecovery
                </Button>
                
                <Router>
                    <Switch>
                        <Route exact path="http://localhost:3001/registration" component={Registration}/>
                    </Switch>
                </Router>



                
                
             </Form> 



             </>


        )
        };
    
}

export default Login;
