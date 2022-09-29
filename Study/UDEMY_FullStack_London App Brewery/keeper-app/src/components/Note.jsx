import React from "react";
import { FileDownload } from "@mui/icons-material";
import DeleteIcon from '@mui/icons-material/Delete';
import Fab from '@mui/material/Fab';


function NoteProps(props) {
    return (
        <div className="note">
            <h1>{props.title}</h1>
            <p>{props.content}</p>
            <Fab onClick={() => {props.deleteNote(props.id)}} startIcon={<FileDownload />}><DeleteIcon /></Fab>
        </div>)
}

export default NoteProps;   