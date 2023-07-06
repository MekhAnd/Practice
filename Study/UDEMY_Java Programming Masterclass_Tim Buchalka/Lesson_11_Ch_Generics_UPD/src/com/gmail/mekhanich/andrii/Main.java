package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {


        Park hydroPark = new Park("Hydro Park");
        hydroPark.setLocation("50.44619674780867, 30.576710975847583");
        River dnipro = new River("Dnipro");
        dnipro.setLocations("50.438219162495095, 30.56778319309237");
        dnipro.setLocations("50.42369079587957, 30.579114623821383");
        dnipro.setLocations("50.40336199329585, 30.58553817375287");

        hydroPark.render();
        dnipro.render();

        Layer<Mappable> map = new Layer<>();
        map.addElement(hydroPark);
        map.addElement(dnipro);
//        map.addElement("sldkjflkjsdlkfj");

        map.render();
    }
}