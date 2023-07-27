package com.gmail.mekhanich.andrii;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        String num = String.format("%10d", 9999999999L);
//        String formattedNum = "("+num.substring(0,3) + ")" + num.substring(3,6) + "-" + num.substring(6,10);
//        System.out.println(formattedNum);

//        Contact andr = new Contact("Andrii",1234567890L);
//        Contact and = new Contact("Andrii",1234567891L);
//
//        Contact email = new Contact("Andrii", "email@email.com");
//
//        andr.mergeContactData(and);
//        andr.mergeContactData(email);
//        System.out.println(andr);

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("Email list", emails);
        printData("Phones list", phones);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);

        System.out.println(emailContacts);
        System.out.println(phoneContacts);

        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmialExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");
        robinHood.addEmail("Vinnitsa Forest");
        System.out.println(robinHood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A\u222aB) Union of emails(A) and phones (B)", unionAB);

        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData(" (A\u2229B) retain all ", intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData(" (A\u2229B) v2 retain all ", intersectBA);

        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData(" (A - B) emails A - phones B", AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);
        printData(" (B - A) phones B - emails A", BMinusA);


            Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printData(" Symmetric Difference: phones and emails", symmetricDiff);

        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);

        printData("v2 Symmetric Difference: phones and emails", symmetricDiff);
    }

    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-------------------------------");
        System.out.println(header);
        System.out.println("_______________________________");
        contacts.forEach(System.out::println);

    }
}