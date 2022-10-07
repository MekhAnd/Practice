import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import Container from "react-bootstrap/esm/Container";
import { Form, Card, Button, Row } from "react-bootstrap";
import { Redirect } from 'react-router'
import { NavLink, useLocation } from "react-router-dom";

import { LOGIN_ROUTE, REGISTRATION_ROUTE, MAIN_ROUTE } from "../utils/consts";
import { registration, login } from "../actions/index";
import Input from "../components/Input";

import {langUA_Auth, langUA_CheckIn, langUA_LogIn, langUA_Acc, langUA_Sign, langUA_SignIn, langUA_Log, } from "../utils/languagesUA"
import { langENG_Auth, langENG_CheckIn, langENG_LogIn, langENG_Acc, langENG_Sign, langENG_SignIn, langENG_Log} from "../utils/languagesENG"

const Auth = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [alias, setAlias] = useState("");
  const [regStatus, setRegStatus] = useState(false)

  const dispatch = useDispatch();
  const location = useLocation();

  
  const lang = useSelector((state) => state.language);
  const isAuth = useSelector((state) => state.user.isAuth);
  const isLogedIn = location.pathname === LOGIN_ROUTE;
  console.log(window.innerHeight)

  return (
    <Container 
      className="container-sm d-flex justify-content-center align-items-center"
      style={{ height: "650px" }}
      
    >
      {isAuth || regStatus ? 
      <Redirect to={MAIN_ROUTE}/>
      :
      (
        <div>
          <Card style={{ width: 600 }} className="p-5">
            <h2 className="m-auto">
              {isLogedIn ? (lang==="ENG"?langENG_Auth:langUA_Auth) : (lang==="ENG"?langENG_CheckIn:langUA_CheckIn)}
            </h2>

            {isLogedIn ? (
              <Form className="d-flex flex-column">
                <Input
                  value={email}
                  setValue={setEmail}
                  type="email"
                  placeholder="Enter your e-mail"
                />
                <Input
                  value={password}
                  setValue={setPassword}
                  type="password"
                  placeholder="Enter your password"
                />
                <Button
                  variant={"outline-secondary"}
                  size={"lg"}
                  className="mt-4 pl-10 pr-10"
                  onClick={() => {
                    dispatch(login(email, password));
                  }}
                >
                 <b>{(lang==="ENG"?langENG_LogIn:langUA_LogIn)}</b>
                </Button>
                <div className="mt-3">
                {(lang==="ENG"?langENG_Acc:langUA_Acc)}{" "}
                  <NavLink to={REGISTRATION_ROUTE}>{(lang==="ENG"?langENG_Sign:langUA_Sign)}</NavLink>
                </div>
              </Form>
            ) : (
              <Form className="d-flex flex-column">
                <Input
                  value={email}
                  setValue={setEmail}
                  type="email"
                  placeholder="Enter your e-mail"
                />
                <Input
                  value={password}
                  setValue={setPassword}
                  type="password"
                  placeholder="Enter your password"
                />
                <Input
                  value={alias}
                  setValue={setAlias}
                  type="text"
                  placeholder="Enter your alias"
                />
                
                <Button
                  variant={"outline-secondary"}
                  size={"lg"}
                  className="mt-4 pl-10 pr-10"
                  onClick={() => {
                    registration(email, password, alias);
                    setRegStatus(true)
                  }}
                >
                  <b>{(lang==="ENG"?langENG_SignIn:langUA_SignIn)}</b>
                </Button>
                <div className="mt-3">
                {(lang==="ENG"?langENG_Log:langUA_Log)} <NavLink to={LOGIN_ROUTE}>{(lang==="ENG"?langENG_LogIn:langUA_LogIn)}</NavLink>
                </div>
              </Form>
            )}
          </Card>
        </div>
      )}
    </Container>
  );
};

export default Auth;
