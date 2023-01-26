package com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook;

import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.Contact;
import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.ContactData;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditContactDialogController {
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
    private ContactData instance = ContactData.getInstance();

    public void editContactCard(Contact contact) {
        lastName.setText(contact.getLastName());
        firstName.setText(contact.getFirstName());
        phoneNumber.setText(contact.getPhoneNumber());
        email.setText(contact.getEmail());
        group.setText(contact.getGroup());
        additionalInformation.setText(contact.getAdditionalInformation());
    }

    public void updateContact(Contact contact) throws IOException {
        contact.setLastName(lastName.getText().trim());
        contact.setFirstName(firstName.getText().trim());
        contact.setPhoneNumber(phoneNumber.getText().trim());
        contact.setEmail(email.getText().trim());
        contact.setGroup(group.getText().trim());
        contact.setAdditionalInformation(additionalInformation.getText().trim());
        instance.saveContactBook();
        }
}
