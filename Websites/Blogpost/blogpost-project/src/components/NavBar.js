import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";

import Container from "react-bootstrap/Container";
import { NavLink } from "react-router-dom";

import "./style/NavBar.css";
import { logOutUser, setUser } from "../redusers/userReduser";
import { check } from "../actions";
import {
  MAIN_ROUTE,
  LOGIN_ROUTE,
  ALL_BLOG_ROUTE,
  ALL_ART_ROUTE,
  WRITE_BLOG_ROUTE,
  CREATE_ART_ROUTE,
  ADMIN_ROUTE,
} from "../utils/consts";
import {
  changeLanguageUA,
  changeLanguageENG,
} from "../redusers/languageReduser";
import {
  langUA_AdminPanel,
  langUA_Blog,
  langUA_Art,
  langUA_Authorization,
  langUA_NewBlog,
  langUA_NewArt,
  langUA_Logout,
} from "../utils/languagesUA";
import {
  langENG_AdminPanel,
  langENG_Blog,
  langENG_Art,
  langENG_Authorization,
  langENG_NewBlog,
  langENG_NewArt,
  langENG_Logout,
} from "../utils/languagesENG";

const NavBar = (props) => {
  const [currentUser, setCurrentUser] = useState({});
  const [role, setRole] = useState("");
  const [language, setLanguage] = useState("ENG");

  const eng = {
    width: "40px",
    height: "40px",
    marginRight: "2%",
    borderRadius: "50%",
    border: "1 solid red",
    textAlign: "center",
    fontSize: "1.1rem",
    fontWeight: "600",
    background: "#646464",
    color: "white",
  };

  const ua = {
    width: "40px",
    height: "40px",
    marginRight: "2%",
    borderRadius: "50%",
    border: "1 solid red",
    textAlign: "center",
    fontSize: "1.1rem",
    fontWeight: "600",
    background: "yellow",
    color: "blue",
  };
  const [style, setStyle] = useState(eng);
  const token = localStorage.getItem("token");
  const dispatch = useDispatch();
  const st = useSelector((state) => state);
  let auth = currentUser.isAuth;
  let languageButton;

  useEffect(() => {
    check().then((data) => {
      setCurrentUser({ currentUser: data, isAuth: true });

      if (data.role === "AUTHOR") {
        setRole("AUTHOR");
      } else if (data.role === "ADMIN") {
        setRole("ADMIN");
      } else {
        setRole("READER");
      }
      console.log(st);
    });
    console.log(st);
  }, [token, auth, language, style]);

  const handleLanguage = () => {
    if (language === "ENG") {
      setLanguage("UA");
      languageButton = "lng-swtch-UA";
      setStyle(ua);
      return dispatch(changeLanguageUA());
    } else {
      setLanguage("ENG");
      languageButton = "lng-swtch-ENG";
      setStyle(eng);
      return dispatch(changeLanguageENG());
    }
  };

  const handleLogout = () => {
    setCurrentUser({ currentUser: {}, isAuth: false });
    return dispatch(logOutUser());
  };

  return (
    <Navbar bg="dark" variant="dark" style={{ textAlign: "right" }}>
      <Container>
        <Nav className="mr-auto">
          {auth & (role === "ADMIN" || role === "AUTHOR") ? (
            <NavLink
              className="m-2"
              style={{ color: "white", textDecoration: "none" }}
              to={ADMIN_ROUTE}
            >
              {language === "ENG" ? langENG_AdminPanel : langUA_AdminPanel}
            </NavLink>
          ) : (
            <div></div>
          )}
          {auth & (role === "AUTHOR" || role === "ADMIN") ? (
            <NavLink
              className="m-2"
              style={{ color: "white", textDecoration: "none" }}
              to={WRITE_BLOG_ROUTE}
            >
              {language === "ENG" ? langENG_NewBlog : langUA_NewBlog}
            </NavLink>
          ) : (
            <div></div>
          )}
          {auth & (role === "AUTHOR" || role === "ADMIN") ? (
            <NavLink
              className="m-2"
              style={{ color: "white", textDecoration: "none" }}
              to={CREATE_ART_ROUTE}
            >
              {language === "ENG" ? langENG_NewArt : langUA_NewArt}
            </NavLink>
          ) : (
            <div></div>
          )}
          <NavLink
            className="m-2"
            style={{ color: "white", textDecoration: "none" }}
            to={{
              pathname: `${ALL_BLOG_ROUTE}`,
              state: {
                page: "main",
              },
            }}
          >
            {language === "ENG" ? langENG_Blog : langUA_Blog}
          </NavLink>
          <NavLink
            className="m-2"
            style={{ color: "white", textDecoration: "none" }}
            to={ALL_ART_ROUTE}
          >
            {language === "ENG" ? langENG_Art : langUA_Art}
          </NavLink>
          {!auth && (
            <NavLink
              className="m-2"
              style={{ color: "white", textDecoration: "none" }}
              to={LOGIN_ROUTE}
            >
              {language === "ENG"
                ? langENG_Authorization
                : langUA_Authorization}
            </NavLink>
          )}
          {auth && (
            <div
              className="m-2"
              style={{ cursor: "pointer", color: "white" }}
              onClick={() => handleLogout()}
            >
              {language === "ENG" ? langENG_Logout : langUA_Logout}
            </div>
          )}
        </Nav>
      </Container>
      <button
        className="lng-swch"
        onClick={() => handleLanguage()}
        style={style}
      >
        {language}
      </button>
    </Navbar>
  );
};

export default NavBar;
