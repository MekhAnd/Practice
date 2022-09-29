import React from "react";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import { NavLink } from "react-router-dom";

import "./style/MenuBar.css";
import { MAIN_ROUTE } from "../utils/consts";

function MenuBar(props) {
  return (
    <Navbar bg="transparence" variant="dark" className="menu-bar">
      <Container id="menu-bar_container">
        <NavLink to={MAIN_ROUTE}>
          <div className="menu-bar_logo"></div>
        </NavLink>
      </Container>
    </Navbar>
  );
}

export default MenuBar;
