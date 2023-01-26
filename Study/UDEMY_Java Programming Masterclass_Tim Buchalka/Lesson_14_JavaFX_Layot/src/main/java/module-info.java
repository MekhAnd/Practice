module com.example.lesson_14_javafx_layot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lesson_14_javafx_layot to javafx.fxml;
    exports com.example.lesson_14_javafx_layot;
}