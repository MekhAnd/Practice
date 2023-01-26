module com.gamil.mekhanich.andrii.lesson_14_javafx_css {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;



    opens com.gamil.mekhanich.andrii.lesson_14_javafx_css to javafx.fxml;
    exports com.gamil.mekhanich.andrii.lesson_14_javafx_css;
}