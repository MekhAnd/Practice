const SET_USER = "SET_USER";
const LOGOUT_USER = "LOGOUT_USER";

const defaultState = {
  currentUser: {},
  isAuth: false,
};

export default (state = {}, action) => {
  switch (action.type) {
    case "SET_USER":
      return {
        ...state,
        currentUser: action.payload,
        isAuth: true,
      };
    case "LOGOUT_USER":
      localStorage.setItem("token", "");
      return {
        ...state,
        currentUser: {},
        isAuth: false,
      };
      case "EDIT_USER":
        // console.log(action.payload)
        return action.payload
    // case "DELETE_USER":
    //   console.log(action.payload);
    //   return action.payload;
    
    default:
      return state;
  }
};

export const setUser = (user) => ({ type: SET_USER, payload: user });
export const logOutUser = (user) => ({ type: LOGOUT_USER, payload: null });
export const editRole = (userRole)=>({type: "EDIT_USER", payload: userRole})

// export const deleteUser = (user) => ({ type: "DELETE_USER", payload: user });
