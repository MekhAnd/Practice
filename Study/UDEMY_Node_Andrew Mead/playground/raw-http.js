require ("dotenv").config()
const http = require("http")

const url = `http://api.weatherstack.com/current?access_key=${process.env.WEATHER_API_KEY}&query=45,-75`;


const request = http.request(url,(response)=>{
    let data = ""
    response.on("data", (chunk)=>{
        data = data + chunk.toString()
    })

    response.on("end", ()=>{
        const body = JSON.parse(data)
    })
})


request.on("error", error=>{
    console.log("Error", error)
})

request.end()