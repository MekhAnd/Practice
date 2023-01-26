module com.example.lesson_14_events {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lesson_14_events to javafx.fxml;
    exports com.example.lesson_14_events;
}