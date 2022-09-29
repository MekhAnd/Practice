import './App.css';
import Footer from './Footer';
import Header from './Header';
import Note from './Note';
import CreateArea from "./CreateArea"
import { useState } from 'react';



function App() {
  const [notes, setNotes] = useState([]);

  function addTo(note) {
    console.log("from app", note);
    setNotes(prevNotes => {
      return [...prevNotes, note];
    })
    console.log("from app", notes);
  }
  
  function deleteNote(id){
    setNotes(prevNotes=>{
      return(notes.filter((item, index) =>{
        return index !== id;
      }))
    })
    
  }


  return (
    <div className="App">
      <Header />
      <CreateArea
        onAdd={addTo} />
      {notes.map((note, index) => {
        return(<Note key={index} 
                     id={index} 
                     title = {note.title} 
                     content = {note.content} 
                     deleteNote = {deleteNote}/>)

      })}

      <Footer />
    </div>
  );
}

export default App;
