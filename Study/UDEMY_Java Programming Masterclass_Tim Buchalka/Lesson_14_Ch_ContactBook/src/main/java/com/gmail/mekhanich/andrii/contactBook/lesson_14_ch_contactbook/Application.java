package com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook;

import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.ContactData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("contact_book-main_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 240);
        stage.setTitle("Contact Book!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop()throws Exception{
        try{
            ContactData.getInstance().saveContactBook();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void init() throws Exception{
        try{
            ContactData.getInstance().loadContactLIst();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}