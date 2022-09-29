export default function getTaggedBlogs(state=[], action){
    switch(action.type){
        case "GET_TAGGED_BLOGS":
            console.log(action.payload)
            return action.playload;
        default:
            return state;
    }
}

export const setListBlogs = (taggedBlogs) =>({ type: "GET_TAGGED_BLOGS", playload: taggedBlogs})