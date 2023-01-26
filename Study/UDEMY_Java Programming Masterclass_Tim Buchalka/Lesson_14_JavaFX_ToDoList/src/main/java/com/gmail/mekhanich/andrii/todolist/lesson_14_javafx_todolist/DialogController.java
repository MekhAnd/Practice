package com.gmail.mekhanich.andrii.todolist.lesson_14_javafx_todolist;

import com.gmail.mekhanich.andrii.datamodel.TodoData;
import com.gmail.mekhanich.andrii.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResult(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadLine = deadlinePicker.getValue();
        TodoItem newItem = new TodoItem(shortDescription, details,deadLine);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;

    }
}
