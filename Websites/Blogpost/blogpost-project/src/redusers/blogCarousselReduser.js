export default function blogReduser(state={}, action){
    switch (action.type){
        case "FETCH_ONE_BLOG":
            // console.log(action.payload)
            return action.payload;
        default:
            return state;
    }
};

export const setOneBlog = (blog) => ({ type: "FETCH_ONE_BLOG", payload: blog });
