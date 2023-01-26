package com.gmail.mekhanich.andrii.contactBook.lesson_14_ch_contactbook.datamodel;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;

public class Contact {
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty email;
    private SimpleStringProperty group;
    private SimpleStringProperty additionalInformation;


    public Contact() {
    }

    public Contact(String lastName, String firstName, String phoneNumber, String email, String group, String additionalInformation) {
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.additionalInformation = new SimpleStringProperty(additionalInformation);
        this.group = new SimpleStringProperty(group);
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public SimpleStringProperty groupProperty() {
        return group;
    }

    public SimpleStringProperty additionalInformationProperty() {
        return additionalInformation;
    }


    public String getGroup() {
        return group.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getAdditionalInformation() {
        return additionalInformation.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation.set(additionalInformation);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
