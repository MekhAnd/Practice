const fs = require("fs");
const chalk = require("chalk");
const yargs = require("yargs");
const notes = require("./notes");

/****** Yargs parsing command line******/

//crating add command
yargs.command({
  command: "add",
  describe: "Add a new note",
  builder: {
    title: {
      describe: "Note title",
      demandOption: true,
      type: "string",
    },
    body: {
      describe: "Note something",
      demandOption: true,
      type: "string",
    },
  },
  handler: function (argv) {
    notes.addNote(argv.title, argv.body);
  },
});

//crating remove command
yargs.command({
  command: "remove",
  describe: "Remove a note",
  builder: {
    title: {
      describe: "Note title",
      demandOption: true,
      type: "string",
    },
  },
  handler: function (argv) {
    notes.removeNote(argv.title);
  },
});

//crating list command
yargs.command({
  command: "list",
  describe: "List all notes",
  handler: function () {
    notes.listNotes();
  },
});

//crating read command
yargs.command({
  command: "read",
  describe: "Read the note",
  builder: {
    title: {
      describe: "Read note",
      demandOption: true,
      type: "string",
    },
  },
  handler: function (argv) {
    notes.readNotes(argv.title);
    },
});

// console.log(process.argv)
yargs.parse(); // or console.log(yargs.argv) for run!!!

/****Chulk colored messages in consolee*****/
// console.log(chalk.green.bold.inverse("Success!"));

/****** File Systen (read and create(add) to file******/

// fs.writeFileSync("notes.txt", "File was created by node.js")
// console.log(__dirname+"/notes.txt")
// fs.appendFileSync("notes.txt", newNote ,err=>{
//     console.log(err)
// })

// console.log(newNote)
