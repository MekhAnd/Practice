const doWorkPromise = new Promise((resolve, reject) => {
  setTimeout(() => {
    // reject("This is my error"); // after timoeut res => "This is my error"
    resolve([1, 5, 9]); // after timeout res => [1,5,9]
  }, 2000);
});


doWorkPromise.then((result)=>{
    console.log(result)
}).catch((error)=>{
    console.log(error)
})