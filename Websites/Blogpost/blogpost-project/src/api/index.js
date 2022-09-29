import axios from "axios"

const $host = axios.create({
    baseURL: process.env.REACT_APP_APIURL
})

const $authHost = axios.create({
    baseURL: process.env.REACT_APP_APIURL
})

const authInterceptor = (config) =>{
   config.headers.authorization = `Bearer ${localStorage.getItem('token')}`
//    console.log("INTERCEPTOR")
    return config
}

$authHost.interceptors.request.use(authInterceptor)

export {
    $host,
    $authHost
}