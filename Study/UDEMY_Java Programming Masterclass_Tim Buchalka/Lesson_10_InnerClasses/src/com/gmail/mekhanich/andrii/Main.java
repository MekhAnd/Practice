package com.gmail.mekhanich.andrii;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {

        // FOR PUBLIC INNER CLASS
        //        Gearbox mcLaren = new Gearbox(6);
//        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);
//        System.out.println(first.driveSpeed(1000));
//
////        Gearbox.Gear second = new Gear(2, 15.4);
//
////        Gearbox.Gear third = new mcLaren.Gear(2, 15.4);
//
//        Gearbox.Gear second = mcLaren.new Gear(2, 15.4);

        Gearbox mcLaren = new Gearbox(6);
//        mcLaren.addGear(1,5.3);
//        mcLaren.addGear(2,10.6);
//        mcLaren.addGear(3,15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.weelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.weelSpeed(1000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.weelSpeed(6000));

//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("I`ve been attached!");
//            }
//
//            @Override
//            public void onCLick(String title) {
//                System.out.println(title + " was clicked!");
//            }
//        }
//        btnPrint.setOnClickListner(new ClickListener());

        // ANIMOUS CLASS
        btnPrint.setOnClickListner(new Button.OnClickListener() {
            @Override
            public void onCLick(String title) {
                System.out.println(title + " was clicked!");
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}