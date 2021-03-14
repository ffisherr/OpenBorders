import React, { Component } from 'react';
import { Container, FormControl, Nav, Navbar, Form, Button} from 'react-bootstrap';


class Registration extends Component{
    render(){
        return(
            <Navbar collapseOnSelect expand="md" bg="dark" variant="dark">
                <Container>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav"/>
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="mr-auto">
                            <Nav.Link href="/registration">Registration</Nav.Link>
                            <Nav.Link href="/password_recowery">Password Recowery</Nav.Link>
                        </Nav>
                        <Form inline>
                            <FormControl
                                type="text"
                            />
                            <Button variant="outline-info">Registration</Button>
                        </Form>
                    </Navbar.Collapse>
                </Container>
            </Navbar> 
        )
    }
}

export default Registration;