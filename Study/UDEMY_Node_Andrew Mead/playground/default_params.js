const greeter = (name )=>{
    console.log(`Hello ${name}`)
}

greeter("Andrii")// Hello Andrii
greeter()// Hello unefined

const greeter2 = (name = "User" )=>{
    console.log(`Hello ${name}`)
}

greeter2("Andrii")// Hello Andrii
greeter2()// Hello User