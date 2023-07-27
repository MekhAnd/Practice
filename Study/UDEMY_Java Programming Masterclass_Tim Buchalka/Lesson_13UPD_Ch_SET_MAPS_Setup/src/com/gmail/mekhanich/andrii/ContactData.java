package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {
    private static final String phoneData = """
            Charlie Brown, 3334445555
            Maid Marion, 1234567890
            Mickey Mouse, 9998887777
            Mickey Mouse, 1247489758
            Minnie Mouse, 4567805666
            Robin Hood, 5647893000
            Robin Hood, 7899028222
            Lucy Van Pelt, 5642086852
            Mickey Mouse, 9998887777
            """;

    private static final String emailData = """
            Mickey Mouse, mckmouse@gmail.com
            Mickey Mouse, micky1@aws.com
            Minnie Mouse, minnie@verizon.net
            Robin Hood, rhood@gmail.com
            Linus Van Pelt, lvpelt2015@gmail.com
            Daffy Duck, daffy@google.com
            """;

    public static List<Contact> getData(String data){
        List<Contact> dataList = new ArrayList<>();
        Scanner sc = new Scanner(data.equals("phone")? phoneData:emailData);
        while (sc.hasNext()){
            String [] dataType =sc.nextLine().split(",");
            Arrays.asList(dataType).replaceAll(String::trim);

            if(data.equals("phone")){
                dataList.add(new Contact(dataType[0], Long.parseLong(dataType[1])));
            } else if(data.equals("email")){
                dataList.add(new Contact(dataType[0], dataType[1]));
            }
        }
        return dataList;
    }
}
