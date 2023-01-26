package com.gamil.mekhanich.andrii.lesson_14_javafx_css;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label label;
    @FXML
    private Button button05;

    @FXML
    private GridPane gridPane;

    public void  initialize(){
        button05.setEffect(new DropShadow());
//        label.setScaleX(2.0);
//        label.setScaleY(2.0);
         }

    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit(){
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void handleClick(){
//        For files
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
        );

//        showOpenMultipleDialog() - > for several files (list of
//        chooser.showOpenDialog(gridPane.getScene().getWindow()); -> for OPEN
//        for save
//        File file01 = chooser.showSaveDialog(gridPane.getScene().getWindow());
//        if(file01 != null){
//            System.out.println(file01.getPath());
//        } else{
//            System.out.println("!!!");
//        }

//        For Folders
//        DirectoryChooser chooser01 = new DirectoryChooser();
//        File file = chooser01.showDialog(gridPane.getScene().getWindow());
//        if(file != null){
//            System.out.println(file.getPath());
//        } else{
//            System.out.println("!!!");
//        }

    }

    @FXML
    public void handleLinkClick(){
        try{
            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
        } catch (URISyntaxException uriSyntaxException){
            uriSyntaxException.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Was clicked");
    }

}