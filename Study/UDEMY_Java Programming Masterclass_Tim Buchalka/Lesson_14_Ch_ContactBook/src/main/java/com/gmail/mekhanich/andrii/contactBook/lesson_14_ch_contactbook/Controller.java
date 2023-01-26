package com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook;

import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.Contact;
import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.ContactData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Controller {
    private List<Contact> contactList;
    @FXML
    private TableView<Contact> contactTable = new TableView<Contact>();
    @FXML
    private BorderPane mainContactBook;

    public void initialize() {

        contactTable.setEditable(true);
        TableColumn<Contact, String> lastName = new TableColumn<Contact, String>("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
        lastName.setMinWidth(125);

        TableColumn<Contact, String> name = new TableColumn<Contact, String>("First Name");
        name.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
        name.setMinWidth(125);

        TableColumn<Contact, String> phoneNumber = new TableColumn<Contact, String>("Phone Number");
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Contact, String>("phoneNumber"));
        phoneNumber.setMinWidth(100);

        TableColumn<Contact, String> email = new TableColumn<Contact, String>("E-mail");
        email.setCellValueFactory(new PropertyValueFactory<Contact, String>("email"));
        email.setMinWidth(75);

        TableColumn<Contact, String> group = new TableColumn<Contact, String>("Group");
        group.setCellValueFactory(new PropertyValueFactory<Contact, String>("group"));
        group.setMinWidth(75);

        TableColumn<Contact, String> addInfo = new TableColumn<Contact, String>("Additional Info");
        addInfo.setCellValueFactory(new PropertyValueFactory<Contact, String>("additionalInformation"));
        addInfo.setMinWidth(300);

        contactTable.getColumns().addAll(lastName, name, phoneNumber, email, group, addInfo);
        ObservableList<Contact> contactData = ContactData.getInstance().getContacts();
        contactTable.setItems(contactData);
    }

    public void showNewContactDialog() {
        Dialog newContactWindow = new Dialog<>();
        newContactWindow.initOwner(mainContactBook.getScene().getWindow());
        newContactWindow.setTitle("Add new Contact here");
        newContactWindow.setHeaderText("Use this dialog to create a new Contact card");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newContactDialog.fxml"));

        try {
            newContactWindow.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Smthng went wrong!!!");
            e.printStackTrace();

        }
        newContactWindow.getDialogPane().getButtonTypes().add(ButtonType.OK);
        newContactWindow.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> dialogResult = newContactWindow.showAndWait();

        if (dialogResult.isPresent() && dialogResult.get() == ButtonType.OK) {
            NewContactDialogController controller = fxmlLoader.getController();
            Contact contact = controller.addNewContact();
            contactTable.setItems(ContactData.getInstance().getContacts());
        } else {
            System.out.println("cancel");
        }

    }
    @FXML
    public void showEditContactDialog() throws IOException {
        Contact cardForEditing = contactTable.getSelectionModel().getSelectedItem();

        if(cardForEditing == null){
            Alert infoPanel = new Alert(Alert.AlertType.INFORMATION);
            infoPanel.setTitle("You should choose card for edit!");
            infoPanel.setContentText("Choose card for edit and push edit button after that!");
            infoPanel.setHeaderText("Warning!");
            infoPanel.showAndWait();
            return;
        }

        Dialog <ButtonType> editContact = new Dialog();
        editContact.initOwner(mainContactBook.getScene().getWindow());
        editContact.setTitle("Edit exists contact here");
        editContact.setHeaderText("Use this dialog to edit a Contact card");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editContactDialog.fxml"));

        try {
            editContact.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Smthng went wrong!!!");
            e.printStackTrace();

        }

        editContact.getDialogPane().getButtonTypes().add(ButtonType.OK);
        editContact.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        EditContactDialogController controller = fxmlLoader.getController();
        controller.editContactCard(cardForEditing);

        Optional<ButtonType> dialogResult = editContact.showAndWait();

        if (dialogResult.isPresent() && dialogResult.get() == ButtonType.OK) {
            controller.updateContact(cardForEditing);
            contactTable.setItems(ContactData.getInstance().getContacts());
            contactTable.setItems(ContactData.getInstance().getContacts());
        } else {
            System.out.println("cancel");
        }



    }

    public void showDeleteDialog() {
        Alert deleteContact = new Alert(Alert.AlertType.CONFIRMATION);
        Contact cardForDeleting = contactTable.getSelectionModel().getSelectedItem();
        deleteContact.setTitle("Are you really would like to delete this Contact card");
        deleteContact.setHeaderText("Delete Item: " + cardForDeleting.getLastName());
        deleteContact.setContentText("Are you sure? Press OK to confirm and CANCEL to Back out!");

        Optional<ButtonType> result = deleteContact.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("OK");
            ContactData.getInstance().deleteContact(cardForDeleting);
        } else {
            System.out.println("NO");
        }
    }



    public void lookingForDialog() {
        Dialog lookingFor = new Dialog<>();
        lookingFor.initOwner(mainContactBook.getScene().getWindow());
        lookingFor.setTitle("Find the Contact here");
        lookingFor.setHeaderText("Use this dialog to looking for the Contact card");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("lookingFor.fxml"));

        try {
            lookingFor.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Smthng went wrong!!!");
            e.printStackTrace();

        }
        lookingFor.getDialogPane().getButtonTypes().add(ButtonType.OK);
        lookingFor.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> dialogResult = lookingFor.showAndWait();
        if (dialogResult.isPresent() && dialogResult.get() == ButtonType.OK) {
            System.out.println("\t lookingFor " + "ok");
            LookingFor controller = fxmlLoader.getController();
            System.out.println(controller.looking());

        } else {
            System.out.println("cancel");
        }
    }


}