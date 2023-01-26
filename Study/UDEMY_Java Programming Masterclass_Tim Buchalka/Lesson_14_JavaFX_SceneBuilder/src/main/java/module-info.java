module com.gamil.mekhanich.andrii.lesson_14_javafx_scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gamil.mekhanich.andrii.lesson_14_javafx_scenebuilder to javafx.fxml;
    exports com.gamil.mekhanich.andrii.lesson_14_javafx_scenebuilder;
}