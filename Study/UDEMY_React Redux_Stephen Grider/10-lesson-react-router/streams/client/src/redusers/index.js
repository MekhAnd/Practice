import { combineReducers } from "redux";
import authReduser from "./authReducer";

export default combineReducers({
  auth: authReduser,
});
