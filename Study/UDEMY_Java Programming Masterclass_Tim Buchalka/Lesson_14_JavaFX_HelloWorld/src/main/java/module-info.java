module com.example.lesson_14_javafx_helloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lesson_14_javafx_helloworld to javafx.fxml;
    exports com.example.lesson_14_javafx_helloworld;
}