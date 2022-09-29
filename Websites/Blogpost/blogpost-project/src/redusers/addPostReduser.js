export default function addPostReduser(state= null, action){
    switch (action.type){
        case "ADD_POST":
            // console.log("ADD POST")
            // console.log("action.type",action.type )
        return action.payload
        case "UPDATE_POST":
            // console.log("UPDATE POST")
            // console.log("action.type",action.type )
        return action.payload
        case "DELETE_POST":
            // console.log("DELETE POST")
            // console.log("action.type",action.type )
        return action.payload
        default:
            return state;
    }
};

export const addPost = (newPost) => ({ type: "ADD_POST", payload: newPost });
export const updatePost = (updatedPost) => ({ type: "UPDATE_POST", payload: updatedPost });
export const deletePost = (deletedPost) => ({ type: "DELETED_POST", payload: deletedPost });