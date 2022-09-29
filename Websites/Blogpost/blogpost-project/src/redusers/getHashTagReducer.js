export default function getHashTagsReduser(state=[], action){
    switch (action.type) {
        case "GET_TAGS":
            console.log("action get all atags", action.payload)
            return action.payload
        default:
            return state;
    }
}

export const allTags = (tags)=>({type:"GET_TAGS", payload:tags})