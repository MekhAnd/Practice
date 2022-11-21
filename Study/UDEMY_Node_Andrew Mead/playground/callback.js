// const geoposition = (address, callback)=>{
//     setTimeout(()=>{
//         const data = {
//             latitude:0,
//             longitude:0
//         }
//         return data // Will not return data => return undefined
//     },2000)
// }

// const currentPosition = geoposition("Kyiv")
// console.log(currentPosition)


// /** RIGHT VARIANT!!!**/
// const geopositionCallback = (address, callback)=>{
//     setTimeout(()=>{
//         const data = {
//             latitude:0,
//             longitude:0
//         }
//         callback(data)
//     },2000)
// }

// geopositionCallback("Kyiv", data=>{
//     console.log(data)
// })

// //
// // Goal: Mess around with the callback pattern
// //
// // 1. Define an add function that accepts the correct arguments
// // 2. Use setTimeout to simulate a 2 second delay
// // 3. After 2 seconds are up, call the callback function with the sum
// // 4. Test your work!

// function add(numA,numB, sum){
    
//     setTimeout(() => {
//       sum(numA+numB) 
//     }, 2000);
// }

// add(1, 4, (sum) => {
//     console.log(sum) // Should print: 5
// })


//promises
const doWorkCallback = (callback)=>{
    setTimeout(() => {
        // callback("This is my error", undefined) // after timoeut res => "This is my error"
        callback(undefined, [1, 5, 9]) // after timeout res => [1,5,9]
    }, 2000);
}

doWorkCallback((error, result)=>{
    if(error){
        return console.log(error)
    }

    console.log(result)
})