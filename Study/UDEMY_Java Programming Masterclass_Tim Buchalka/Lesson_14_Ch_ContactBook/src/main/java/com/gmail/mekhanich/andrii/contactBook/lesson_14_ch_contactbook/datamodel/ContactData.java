package com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class ContactData {

    private static ContactData instance = new ContactData();
    private static String contactInfo = "contactBook.txt";

    private ObservableList<Contact> contacts;

    public ContactData() {
    }

    public static ContactData getInstance() {
        return instance;
    }

    public ObservableList<Contact> getContacts() {
//        System.out.println("Get Observ List ContactData");
//        System.out.println(contacts);
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void setContactData(List<Contact> contacts) {
        this.contacts = (ObservableList<Contact>) contacts;
    }

    public void loadContactLIst() throws IOException {
        contacts = FXCollections.observableArrayList();
        Path path = Paths.get(contactInfo);
        File savedFile = new File(contactInfo);

        if (savedFile.exists()) {
//            System.out.println("Ok file is exists");
        } else {
            try {
                savedFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {

            while ((input = br.readLine()) != null) {
                String[] contactInfo01 = input.split("\t");

                String lastName = contactInfo01[0];
                String firstName = contactInfo01[1];
                String phoneNumber = contactInfo01[2];
                String email = contactInfo01[3];
                String group = contactInfo01[4];
                String additionalInformation = contactInfo01[5];

                Contact newContact = new Contact(lastName, firstName, phoneNumber, email, group, additionalInformation);

                contacts.add(newContact);
            }

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void saveContactBook() throws IOException {
        Path path = Paths.get(contactInfo);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<Contact> iterator = contacts.iterator();
            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                bw.write(String.format("%s\t%s\t%s\t%s\t%s\t%s",
                        contact.getLastName(),
                        contact.getFirstName(),
                        contact.getPhoneNumber(),
                        contact.getEmail(),
                        contact.getGroup(),
                        contact.getAdditionalInformation()));
                bw.newLine();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }
}
