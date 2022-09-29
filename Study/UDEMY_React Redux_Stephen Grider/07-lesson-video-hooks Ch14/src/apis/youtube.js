import axios from "axios";

const KEY = "AIzaSyCncOPDY16IxpqnLZ_okzlJQKfO6ep-dRA";

export default axios.create({
    baseURL : "https://www.googleapis.com/youtube/v3",
    params : {
        part :"snippet",
        type: "video",
        maxResults: 3,
        key: KEY
    }
});

