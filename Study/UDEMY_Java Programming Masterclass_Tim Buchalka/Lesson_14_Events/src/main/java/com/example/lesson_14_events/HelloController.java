package com.example.lesson_14_events;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void handleChange(){
        System.out.println("The check box is " + (checkBox.isSelected()? "checked": "not checked"));
    }
    @FXML
    public void onButtonClicked(ActionEvent event) {

        if (event.getSource().equals(helloButton)) {
            System.out.println("Hello!! " + nameField.getText() + "!");
        } else if (event.getSource().equals(byeButton)) {
            System.out.println("Good Bye my friend GOOOOODBYE!! " + nameField.getText() + "!");
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" :  "Background Thread";
                    System.out.println( "I`m going to sleep on the :" +s);
                    Thread.sleep(10000);
                    Platform.runLater((new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" :  "Background Thread";
                            System.out.println( "I`m updating the label on the :" +s);
                            ourLabel.setText("We did something!");
                        }
                    }));

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(task).start();
        if(checkBox.isSelected()){
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
//        System.out.println(event.getSource() + "was pressed");
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }


}