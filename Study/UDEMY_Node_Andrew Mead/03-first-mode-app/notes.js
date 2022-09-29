const fs = require("fs");
const chalk = require("chalk");

const getNotes = () => {
  return "  Your note is...";
};

const addNote = (title, body) => {
  const notes = loadNotes();
  const duplicatedNote = notes.find((note) => {
    return note.title === title;
  });

  if (!duplicatedNote) {
    notes.push({ title: title, body: body });
    saveNotes(notes);
    console.log(notes);
  } else {
    console.log("Note title taken!");
  }
};

const removeNote = (title) => {
  console.log("notes removeNote", title);
  const notes = loadNotes();
  const newNotes = notes.filter((note) => {
    return note.title != title;
  });
  if (notes.length !== newNotes.length) {
    console.log(chalk.green.bold.inverse("Note removed!"));
    saveNotes(newNotes);
  } else {
    console.log(chalk.red.bold.inverse("Note not found!"));
  }
};

const listNotes = () => {
  const notes = loadNotes();
  console.log(chalk.blue.bold.inverse("Your notes "))
  notes.forEach(note => {console.log(note.title)});
};
const readNotes = (title) => {
  const notes = loadNotes();
  const currentNote = notes.find(note=>note.title === title)
  if (currentNote) {
    console.log(chalk.bold.yellow.inverse(currentNote.title));
    console.log(chalk.bold.blue.inverse(currentNote.body));
  } else{
    console.log(chalk.red.inverse.bold("Not exist"))
  }

};

const loadNotes = function () {
  try {
    const dataBuffer = fs.readFileSync("notes.json");
    const dataJSON = JSON.parse(dataBuffer.toString());
    return dataJSON;
  } catch (error) {
    return [];
  }
};

const saveNotes = (notes) => {
  const dataJSON = JSON.stringify(notes);
  fs.writeFileSync("notes.json", dataJSON);
};

module.exports = {
  getNotes: getNotes,
  addNote: addNote,
  removeNote: removeNote,
  listNotes: listNotes,
  readNotes: readNotes,
};
