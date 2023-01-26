module com.example.lesson_14_javafx_controls {
    requires javafx.controls;
    requires javafx.fxml;
    requires jlfgr;


    opens com.example.lesson_14_javafx_controls to javafx.fxml;
    exports com.example.lesson_14_javafx_controls;
}