export default function blogReduser(state=[], action){
    switch (action.type){
        case "FETCH_ALL_BLOGS":
            return action.payload;
        default:
            return state;
    }
};

export const setBlogs = (blogs) => ({ type: "FETCH_ALL_BLOGS", payload: blogs });

