export default function languageReduser(state="ENG", action){
    
    switch (action.type) {
        case "CHANGE_LANGUAGE_UA": 
            return "UA"
        case "CHANGE_LANGUAGE_ENG":
            return "ENG"
        default:
            return state;
    }
}

export const changeLanguageUA = (language) => ({ type: "CHANGE_LANGUAGE_UA", payload: language})
export const changeLanguageENG = (language) => ({ type: "CHANGE_LANGUAGE_ENG", payload: language})