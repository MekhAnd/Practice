export default function addHashTagReduser(state=null, action){
    switch(action.type){
        case "ADD_HASHTAG":
            console.log("reduser hash, got this", action.payload)
            return action.payload
        case "CONNECT_TAG":
            // console.log("reduser hash, got this", action.payload)
            return action.payload
        default:
            return null;
    }
}

export const addTag = (hashTag) => ({type: "ADD_HASHTAG", payload: hashTag})
export const connectTag = (hashTag)=>({type:"CONNECT_TAG", payload: hashTag})