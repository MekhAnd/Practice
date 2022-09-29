//Action Creator
export const selectSong = (song)=>{
    //return the action
    return{
        type:"SONG_SELECTED",
        payload: song
    };
};

