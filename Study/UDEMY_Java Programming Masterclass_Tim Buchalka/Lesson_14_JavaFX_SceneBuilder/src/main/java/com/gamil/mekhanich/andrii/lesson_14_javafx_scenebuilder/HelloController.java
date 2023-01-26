package com.gamil.mekhanich.andrii.lesson_14_javafx_scenebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label label;

    @FXML
    public void handleAction() {
        label.setText("Button pressed");
    }
}