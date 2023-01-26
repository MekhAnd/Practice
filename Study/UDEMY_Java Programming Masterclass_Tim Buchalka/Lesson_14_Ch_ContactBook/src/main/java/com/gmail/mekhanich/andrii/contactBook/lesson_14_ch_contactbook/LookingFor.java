package com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook;

import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.Contact;
import com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel.ContactData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Iterator;

public class LookingFor {
    @FXML
    private TextField info;

    public Contact looking() {
        String lookingContactInfo = info.getText().trim();
        ObservableList<Contact> contacts = ContactData.getInstance().getContacts();
        Iterator<Contact> iterator = contacts.iterator();
        Contact contact = new Contact();
        for (Contact oneOf: contacts) {
            if (lookingContactInfo == oneOf.getLastName() || lookingContactInfo == oneOf.getFirstName() ||
                    lookingContactInfo == oneOf.getPhoneNumber() || lookingContactInfo == oneOf.getEmail()) {

                return new Contact(oneOf.getLastName(), oneOf.getFirstName(), oneOf.getPhoneNumber(),
                        oneOf.getEmail(), oneOf.getGroup(), oneOf.getAdditionalInformation());
            }}

        System.out.println("Second call" + contact);
      return (contact!=null)? contact: null;
    }

}
