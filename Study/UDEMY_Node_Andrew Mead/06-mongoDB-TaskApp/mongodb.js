// const mongodb = require("mongodb");
// const MongoClient = mongodb.MongoClient;
// const ObjectID = mongodb.ObjectId;

const { MongoClient, ObjectId } = require("mongodb");

const connectionURL = "mongodb://127.0.0.1:27017";
const database = "task-manager_AMNC";

// const id = new ObjectId()

// console.log(id)
// console.log(id.getTimestamp())
// console.log(id.toHexString())

MongoClient.connect(
  connectionURL,
  { useNewUrlParser: true },
  (error, client) => {
    if (error) {
      return console.log("Unable to connect to database!");
    }

    const db = client.db(database); // create db
    const users = db.collection("users"); //create collection
    const tasks = db.collection("tasks");

    //DELETE OPERATIONS

    // tasks.deleteOne(
    //         {description: "Third Task"}
    //         ).then(result=>{
    //             console.log(result)
    //         }).catch(error=>{
    //             console.log(error)
    //         })

    tasks
      .deleteMany({
        completed: true,
      })
      .then((result) => {
        console.log(result);
      })
      .catch((error) => {
        console.log(error);
      });

    // const updatePromise = users
    //   .updateOne(
    //     {
    //       _id: new ObjectId("637a48c9ab3482720c4288f7"),
    //     },
    //     {
    //       $inc: {
    //         age: -1,
    //       },
    //     }
    //   )
    //   .then((result) => {
    //     console.log("RESULT", result);
    //   })
    //   .catch((error) => {
    //     console.log("ERROR!", error);
    //   });

    //       $currentDate

    // Sets the value of a field to current date, either as a Date or a Timestamp.
    // $inc

    // Increments the value of the field by the specified amount.
    // $min

    // Only updates the field if the specified value is less than the existing field value.
    // $max

    // Only updates the field if the specified value is greater than the existing field value.
    // $mul

    // Multiplies the value of the field by the specified amount.
    // $rename

    // Renames a field.
    // $set

    // Sets the value of a field in a document.
    // $setOnInsert

    // Sets the value of a field if an update results in an insert of a document. Has no effect on update operations that modify existing documents.
    // $unset

    // Removes the specified field from a document.

    // OR
    // updatePromise.then((result)=>{
    //     console.log("RESULT",result)
    // }).catch((error)=>{
    //     console.log("ERROR!",error)
    // })

    // tasks.updateMany(
    //     {completed: false},
    //     {   $set: {
    //             completed: true
    //         }}
    //     ).then(result=>{
    //         console.log(result)
    //     }).catch(error=>{
    //         console.log(error)
    //     })

    // tasks.find({}).toArray((error,tasks)=>{
    //     if (error) {
    //         return console.log("Unuble to find!!!")
    //     }

    //     console.log("ALL TASKS", tasks[tasks.length-1])
    // })

    // const lastTask = tasks.findOne({_id:new ObjectId("637a4596a61d2fa650f45282")},(error,task)=>{
    //     if (error) {
    //         return console.log("Unuble to find!!!")
    //     }

    //     console.log("LAST", task)
    // })

    // console.log("WTF",lastTask)

    // tasks.find({ completed: false }).toArray((error,tasks)=>{
    //     if (error) {
    //         return console.log("Unuble to find!!!")
    //     }

    //     console.log(tasks)
    // })

    // const currentUser = users.findOne({_id:new ObjectId("637a43dcc8adfff6d52c84c4")}, (error,user)=>{
    //     if(error){
    //         return console.log("Can not find this user")
    //     }

    //     console.log(user)
    // })

    // const allSearch = users.find({ age:46 }).toArray((error, users)=>{
    //     if(error){
    //         return console.log("Unable to find!")
    //     }

    //     console.log(users)
    // })

    // const allSearchCount = users.find({ age:46 }).count((error, count)=>{
    //     if(error){
    //         return console.log("Unable to find!")
    //     }

    //     console.log(count)
    // })

    // console.log(currentUser)

    // users.insertOne({
    //     _id: id,
    //     name:"Andy",
    //     age: 47
    // }

    // , (error, result)=>{
    //     if(error){
    //         return console.log("Unable to insert user!")
    //     }

    //     console.log(result.connection)
    // }

    // )}

    // users.insertMany([{
    //     name: "Liudmila",
    //     age: 45
    // },{
    //     name: "Kate",
    //     age: 23
    // }]
    // )

    //     tasks.insertMany([{
    //         description: "First Task",
    //         completed: true
    //     },
    //     {
    //         description: "Second Task",
    //         completed: false
    //     },
    //     {
    //         description: "Third Task",
    //         completed: false
    //     }
    // ])
  }
);
