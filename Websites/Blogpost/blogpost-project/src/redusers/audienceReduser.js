export default function audienceReduser(state=[], action){
    switch (action.type){
        case "FETCH_ALL_USERS":
            // console.log(action.payload)
            return action.payload;
        default:
            return state;
    }
};

export const allAudience = (audience) => ({ type: "FETCH_ALL_USERS", payload: audience });
