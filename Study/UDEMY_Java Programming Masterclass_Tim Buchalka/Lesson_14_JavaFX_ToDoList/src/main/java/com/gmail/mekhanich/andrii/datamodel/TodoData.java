package com.gmail.mekhanich.andrii.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItem.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;



    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public static TodoData getInstance() {
        return instance;
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem item){
        todoItems.add(item);
    }


//    public void setTodoItems(List<TodoItem> todoItems) {
//        this.todoItems = todoItems;
//    }

    public void loadToDoItems() throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader bufr = Files.newBufferedReader(path);



        String input;

        try {
            while ((input = bufr.readLine()) != null) {
                String[] itemPieces = input.split("\t");
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, formatter);
                TodoItem todoItem = new TodoItem(shortDescription, details, date);
                todoItems.add(todoItem);
            }
        } finally {
            if (bufr != null) {
                bufr.close();
            }
        }
    }

    public void storeToDoItems() throws IOException{
        Path path = Paths.get(filename);
        BufferedWriter bufw = Files.newBufferedWriter(path);

        try {
            Iterator<TodoItem> iter  = todoItems.iterator();
            while(iter.hasNext()){
                TodoItem item = iter.next();
                bufw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline()));
                bufw.newLine();
            }
        } finally {
            if (bufw != null) {
                bufw.close();
            }
        }
    }

    public void deleteTodoItem(TodoItem item){
        todoItems.remove(item);
    }
}
