package com.gmail.mekhanich.andrii;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);

    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if(email!=null) this.emails.add(email);
        if(phone!= 0) {
            this.phones.add(convertNum(phone));
        }
    }

    public String getName() {
        return name;
    }

    public String getLastNameFirst(){
        return  name.substring(name.indexOf(" ")+1) +", " +
                name.substring(0, name.indexOf(" "));
    }

    public Set<String> getEmails() {
        return emails;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public String convertNum(long phone){
        String num = String.format("%10d", phone);
        return "("+num.substring(0,3) + ")" + num.substring(3,6) + "-" + num.substring(6,10);

//        String timSolution = String.valueOf(phone);
//        timSolution = "(%s) %s-%s".formatted(timSolution.substring(0,3), timSolution.substring(3,6), timSolution.substring(6,10));
    }

    public Contact mergeContactData(Contact contact){
        Collections.addAll(this.emails, contact.getEmails().toArray(new String [contact.getEmails().size()]));
        Collections.addAll(this.phones, contact.getPhones().toArray(new String [contact.getEmails().size()]));
        return this;
    }

          @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        int result = 33 * getName().hashCode();
        return result;
    }

    public void addEmail(String companyName){

        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length-1],companyName.replaceAll(" ","").toLowerCase());
        if(!emails.add(email)){
            System.out.println(name + " already exists");
        } else {
//            emails.add(email);
            System.out.println(name + " now has email " + email);
        }
    }

    public void replaceEmialExists(String oldMail, String newMail){
        if(emails.contains(oldMail)){
            emails.remove(oldMail);
            emails.add(newMail);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }
}
