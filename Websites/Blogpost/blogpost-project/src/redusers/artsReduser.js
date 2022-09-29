export default function artsReduser(state=[], action){
    switch (action.type){
        case "FETCH_ALL_ARTS":
            // console.log("FETCH_ALL_ARTS", action.payload)
            return action.payload;
        default:
            return state;
    }
};

export const setArts = (arts) => ({ type: "FETCH_ALL_ARTS", payload: arts });