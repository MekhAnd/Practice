import axios from "axios";

export default axios.create({
    baseURL:"https://api.unsplash.com",
    headers: {
        Authorization:
          "Client-ID rvCoF_d_lwZUOcaZwdr-I0Ms9_GHGun064jjotUqQZQ",
      }
})