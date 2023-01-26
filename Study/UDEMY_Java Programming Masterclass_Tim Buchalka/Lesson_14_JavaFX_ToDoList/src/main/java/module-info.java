module com.gmail.mekhanich.andrii.todolist.lesson_14_javafx_todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gmail.mekhanich.andrii.todolist.lesson_14_javafx_todolist to javafx.fxml;
    exports com.gmail.mekhanich.andrii.todolist.lesson_14_javafx_todolist;
}