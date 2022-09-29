package com.gmail.mekhanich.andrii;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        File xml = new File("NBU.xml");
        Exchange rate = new Exchange();
        saveRate(xml, request());
        System.out.println(Arrays.toString(request().split("\n")));


        try {
            JAXBContext jc = JAXBContext.newInstance(Exchange.class,Currency.class);
            Marshaller marsh = jc.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Unmarshaller un = jc.createUnmarshaller();
            rate = (Exchange) un.unmarshal(xml);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(rate);

    }

    public static String request() {
        String res = "";
        try {
            URL link = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange");
            HttpURLConnection connect = (HttpURLConnection) link.openConnection();
            StringBuilder sb = new StringBuilder();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = bfr.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);

            System.out.println(sb.toString());
            res = sb.toString();
            connect.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void saveRate(File out, String res){
        StringBuilder sb = new StringBuilder();
        try (PrintWriter pw = new PrintWriter(new FileWriter(out))){
                pw.println(res);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
//    HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create("https://yfapi.net/v8/finance/chart/AAPL"))
//            .header("x-api-key", "YOUR-PERSONAL-API-KEY")
//            .method("GET", HttpRequest.BodyPublishers.noBody())
//            .build();
//    HttpResponse<String> response = HttpClient.newHttpClient()
//            .send(request, HttpResponse.BodyHandlers.ofString());
//System.out.println(response.body());