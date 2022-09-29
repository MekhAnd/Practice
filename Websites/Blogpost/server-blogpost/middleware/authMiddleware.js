const jwt = require("jsonwebtoken");

module.exports = function(req,res,next){
    if(req.method === "OPTIONS"){
        next()
    }
    try {
        const token = req.headers.authorization.split(" ")[1];
        if(!token){
            return res.status(401).json({message:"The user is not authorized"})    
        }
        const decoder = jwt.verify(token, process.env.AUTH_KEY)
        req.user = decoder
        next()
    } catch (error) {
        res.status(401).json({message:"The user is not authorized"})
    }
}