package com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook;

import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.Contact;
import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.ContactData;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewContactDialogController {
    @FXML
    private TextField lastName;
    @FXML
    private TextField firstName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private TextField group;
    @FXML
    private TextField additionalInformation;

    public Contact addNewContact() {
        String lastNameField = lastName.getText().trim();
        String firstNameField = firstName.getText().trim();
        String phoneNumberField = phoneNumber.getText().trim();
        String emailField = email.getText().trim();
        String groupField = group.getText().trim();
        String notesField = additionalInformation.getText().trim().isEmpty()?firstName.getText().trim() + " " + lastName.getText().trim():additionalInformation.getText().trim();
        Contact newContact = new Contact(lastNameField, firstNameField, phoneNumberField,
                emailField, groupField, notesField);
        ContactData.getInstance().addContact(newContact);
        return newContact;
    }
}
