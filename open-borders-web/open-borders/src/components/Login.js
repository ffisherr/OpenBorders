import React, {Component} from 'react';
import {Navbar, Nav, Button, Container, Modal, Form, Col} from 'react-bootstrap';
import { Switch, BrowserRouter as Router, Route, Link } from 'react-router-dom';

import Registration from './Registration';

class Login extends Component {


        handleShow () {
            window.location.assign('http://localhost:3000/registration');
            console.log('Открываем окно');
        }

        render() {
        return(
            <>

            <Form className="login">
                <Col xs={12}>
                <Form.Group controlId="formBasicUsername">
                    <Form.Label >Имя пользователя</Form.Label>
                    <Form.Control type="username" placeholder="Имя пользователя" />
                </Form.Group>
                </Col>

                <Col xs={12}>
                <Form.Group controlId="formBasicPassword">
                    <Form.Label>Пароль</Form.Label>
                    <Form.Control type="password" placeholder="Пароль" />
                </Form.Group>
                </Col>

                <Col className="buttoninput">
                <Button variant="primary" type="Input" className="mr-3"size="lg" block>
                    Войти  
                </Button>
                </Col>

                <Col className="buttons2">
                <Button variant="primary" type="Registration"className="mr-3" onClick={this.handleShow.bind(this)}>
                    Регистрация
                </Button>
                
                <Button variant="primary" type="PasswordRecovery">
                    Восстановление пароля
                </Button>
                </Col>

                <Router>
                    <Switch>
                        <Route exact path="http://localhost:3000/registration" component={Registration}/>
                    </Switch>
                </Router>
                




                
                
             </Form> 



             </>


        )
        };
    
}

export default Login;
