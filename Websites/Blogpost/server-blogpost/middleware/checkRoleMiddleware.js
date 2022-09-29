const jwt = require("jsonwebtoken");

module.exports = function (role){
    
    return function(req,res,next){
        if(req.method === "OPTIONS"){
            next()
        }
        try {
            const token = req.headers.authorization.split(" ")[1];
            if(!token){
                return res.status(401).json({message:"The user is not authorized"})    
            }
            const decoder = jwt.verify(token, process.env.AUTH_KEY)
            
            if(decoder.role !== role){
                return res.status(403).json({message:"Your access level doesn`t give you the required rights to complete this operation"})    
            }
            req.user = decoder
            next()
        } catch (error) {
            res.status(401).json({message:"The user is not authorized"})
        }
    }
}

