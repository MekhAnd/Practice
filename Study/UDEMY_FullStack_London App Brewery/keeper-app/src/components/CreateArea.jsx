import React from "react";
import { useState } from "react";
import AddIcon from '@mui/icons-material/Add';
import Fab from '@mui/material/Fab';
import Zoom from '@mui/material/Zoom';


function CreateArea(props) {
    const [status, setStatus] = useState(false);
    const [note, setNote] = useState({
        title: "",
        content: ""
    })


    function writeNote(event) {
        const { name, value } = event.target;
        setNote(prevNote => {
            return {
                ...prevNote,
                [name]: value
            }
        })
    }

    function submitNote(event) {
        props.onAdd(note);
        event.preventDefault();
        setNote({ title: "", content: "" })
    }

    function wrapTextArea() {
        console.log(status);
       setStatus(true);
    }



    return (
        <div >
            <form className="create-note">
                    <input onClick={wrapTextArea} onChange={writeNote} name="title" type="text" value={note.title} placeholder="Task Title" />
                <Zoom in={status ? true:false} style = {{display: !status && "none"}}>
                    <textarea onChange={writeNote} name="content" value={note.content} cols="30" rows= {status ? "3":"1"} placeholder="Task ..."></textarea>
                </Zoom>
                <Zoom in={status ? true:false}>
                    <Fab onClick={submitNote}><AddIcon /></Fab>
                </Zoom>
            </form>
        </div>
    );
}
export default CreateArea;

// < color="primary" aria-label="add">