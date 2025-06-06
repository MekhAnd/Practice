package com.gmail.mekhanich.andrii.todolist.lesson_14_javafx_todolist;

import com.gmail.mekhanich.andrii.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Todo List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {

        try {
            TodoData.getInstance().storeToDoItems();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void init() throws Exception {
        try {
            TodoData.getInstance().loadToDoItems();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}