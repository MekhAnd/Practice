import React from "react";
import { combineReducers } from "redux";
import postReduser from "./postReduser";
import userRedusers from "./userRedusers";

export default combineReducers({
    posts: postReduser,
    users: userRedusers
})


