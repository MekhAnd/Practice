import { combineReducers } from "redux";

const songsReducer = () => {
  return [
    { title: "Кривий танець", duration: "6:11" },
    { title: "Козак", duration: "4:20" },
    { title: "Все єто рок-н-рол", duration: "5:33" },
    { title: "Солнце сідає", duration: "3:11" },
    { title: "After hours", duration: "5:51" },
    { title: "Blow me", duration: "4:42" },
    { title: "Zoolook", duration: "3:53" },
    { title: "Summer 2007", duration: "3:17" },
    { title: "Killer Queen", duration: "3:02" },
    { title: "Locked and loaded", duration: "4:29" },
  ];
};

const selectedSongReducer = (selectedSong = null, action) => {
  if (action.type === "SONG_SELECTED") {
    return action.payload;
  }
  return selectedSong;
};

export default combineReducers({
    songs:songsReducer,
    selectedSong:selectedSongReducer
});

