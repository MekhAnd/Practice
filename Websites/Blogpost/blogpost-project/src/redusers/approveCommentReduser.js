export default function approveCommentReduser (state="", action){
    switch (action.payload) {
        case "APPROVE_COMMENT":
            return action.payload
        default:
            return state;
    }
}

export const approveComment = (approve) => ({ type: "APPROVE_COMMENT", payload: approve });