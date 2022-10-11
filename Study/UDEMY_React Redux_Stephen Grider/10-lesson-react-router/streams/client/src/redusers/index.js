import { combineReducers } from "redux";
import { reducer as formReducer } from "redux-form";
import authReduser from "./authReducer";
import streamReduser from "./streamReduser";

export default combineReducers({
  auth: authReduser,
  form: formReducer,
  streams: streamReduser,
});
