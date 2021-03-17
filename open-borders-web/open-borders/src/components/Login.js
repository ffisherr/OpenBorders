import React, {Component} from 'react';
import {Navbar, Nav, Button, Container, Modal, Form} from 'react-bootstrap';

class Login extends Component {

        state = {
            showRegistration: false,
        };

        handleClose() {
            this.setState({showRegistration: false});
            console.log('Закрываем окно');
        }

        handleShow () {
            this.setState({showRegistration: true});
            console.log('Открываем окно');
        }

        render() {
        return(
            <Form>
                <Form.Group controlId="formBasicEmail">
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

                <Modal show={this.state.showRegistration} onHide={this.handleClose.bind(this)}>
                    <Modal.Header closeButton>
                        <Modal.Title>Registration</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group controlId="fromBasicEmail">
                                <Form.Label>Email Adress</Form.Label>
                                <Form.Control type="email" placeholder="Enter email"/>
                            </Form.Group>
                            <Form.Group controlId="fromBasicPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control type="password" placeholder="Enter password"/>
                            </Form.Group>
                            <Form.Group controlId="fromBasicCheckBox">
                                <Form.Control type="checkbox" placeholder="Remember password"/>
                            </Form.Group>
                        </Form>
                    </Modal.Body>
                </Modal>

             </Form> 

        )
        };
    
}

export default Login;
