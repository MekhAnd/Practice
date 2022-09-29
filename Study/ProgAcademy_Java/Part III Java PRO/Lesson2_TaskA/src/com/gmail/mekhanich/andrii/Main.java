package com.gmail.mekhanich.andrii;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

    Schedule today = new Schedule();
    File out = new File("output.xml");


    try {
        File in = new File("Список поездов.xml");
        JAXBContext jc = JAXBContext.newInstance(Schedule.class, Train.class);
        Marshaller mar = jc.createMarshaller();

        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Unmarshaller unmar = jc.createUnmarshaller();
        today = (Schedule) unmar.unmarshal(in);
        for (Train train:today.getGraph()) {
            train.setTruDate();
        }
        System.out.println(today);

    } catch (JAXBException | ParseException e){
        e.printStackTrace();
    }

        Train vin = new Train("3", "Kyiv", "Vinnitsa", "19.12.2021", "16:05");
        today.addTrain(vin);

        Train khm = new Train("6","Kyiv", "Khmelnitstiy", "19.12.2021", "16:15");
        today.addTrain(khm);

        Train zhm = new Train("4","Kyiv", "Zhitomir", "19.12.2021", "17:20");
        today.addTrain(zhm);

        Train riv = new Train("5","Kyiv", "Rivne", "19.12.2021", "18:25");
        today.addTrain(riv);


        Train trn = new Train("7","Kyiv", "Ternopil", "19.12.2021", "19:30");
        today.addTrain(trn);

        System.out.println(today.toString());


        System.out.println("Please, set the time which will be most preferable for you.");
        System.out.println("The time should be in format dd.MM.yyyy HH:mm");
        System.out.println("Interval start date, pls:");
        Scanner sc= new Scanner(System.in);
        try {
            Date firstDate = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(sc.nextLine());
            System.out.println("Interval end date, pls:");
            Date secondDate = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(sc.nextLine());
            System.out.println("Thank you, lis with all possible variants is ready");

            for (Train train: today.getGraph()) {
                if(train.getSdfDate().after(firstDate)&&train.getSdfDate().before(secondDate)){
                    System.out.println(train);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext jc = JAXBContext.newInstance(Schedule.class, Train.class);
            Marshaller mar = jc.createMarshaller();

            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            mar.marshal(today,out);

        } catch (javax.xml.bind.JAXBException e){
            e.printStackTrace();
        }


    }





}
