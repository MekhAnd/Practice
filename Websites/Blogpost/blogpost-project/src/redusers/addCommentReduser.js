export default function addCommentReduser(state= null, action){
    switch (action.type){
        case "ADD_COMMENT":
            // console.log("ADD COMMENT")
            // console.log("action.type",action.type )

            return action.payload
        case "DELETE_COMMENT":
            // console.log("DELETE COMMENT")
            // console.log("action.type",action.type )
            return action.payload

        default:
            return state;
    }
};

export const addComment = (comment) => ({ type: "ADD_COMMENT", payload: comment });
export const deletedComment = (delComment) => ({ type: "ADD_COMMENT", payload: delComment });