import { combineReducers } from "redux";
import authReduser from "./authReduser";

export default combineReducers({
  auth: authReduser,
});
