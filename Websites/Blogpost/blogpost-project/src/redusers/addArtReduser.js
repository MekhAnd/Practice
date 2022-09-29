export default function addArtReduser(state= null, action){
    switch (action.type){
        case "ADD_ART":
            console.log("ADD ART")
            console.log("action.type",action.type )
        return action.payload
        case "UPDATE_ART":
            // console.log("UPDATE ART")
            // console.log("action.type",action.type )
        return action.payload
        case "DELETE_ART":
            // console.log("DELETE ART")
            // console.log("action.type",action.type )
        return action.payload
        default:
            return state;
    }
};

export const addArt = (newArt) => ({ type: "ADD_ART", payload: newArt });
export const deletedArt = (deletedArt) => ({ type: "DELETE_ART", payload: deletedArt });
export const updatedArt = (updatedArt) => ({ type: "UPDATE_ART", payload: updatedArt });