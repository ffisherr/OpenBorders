import React, {useState} from 'react';
import {Navbar, Nav, Button, Container, Modal, Form} from 'react-bootstrap';

export default function Login() {

        const [show, setShow] = useState(false);

        const handleClose = () =>setShow(false);
        const handleShow = () =>setShow(true);


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

                <Button variant="primary" type="Registration"className="mr-3" onClick={handleShow}>
                    Registration
                </Button>
                
                <Button variant="primary" type="PasswordRecovery">
                    PasswordRecovery
                </Button>

                <Modal show={show} onHide={handleClose}>
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
    
}

