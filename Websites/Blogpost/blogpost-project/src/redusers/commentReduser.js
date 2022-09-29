export default function commentReduser(state=[], action){
    switch (action.type){
        case "FETCH_ALL_COMMENTS":
            return action.payload;
        default:
            return state;
    }
};

export const setComment = (comments) => ({ type: "FETCH_ALL_COMMENTS", payload: comments });
