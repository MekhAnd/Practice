package com.gmail.mekhanich.andrii;

import static com.gmail.mekhanich.andrii.Mappable.mapIt;

public class Main {
    public static void main(String[] args) {
        Building rada = new Building("Rada", BuildingTypes.GOVERNMENT, Color.BLUE, PointMarker.PIN);
        Building mariinskiyPalats = new Building("Mariinskiy Palac", BuildingTypes.GOVERNMENT, Color.BLUE, PointMarker.PIN);

        UtilityLine internetLine = new UtilityLine("internet line", UtilityType.FIBER_OPTIC, Color.GRAY, LineMarker.SOLID);
        UtilityLine water = new UtilityLine("water pipes", UtilityType.WATER_PIPES, Color.BLACK, LineMarker.DOTTED);

        Mappable.mapIt(rada);
        Mappable.mapIt(mariinskiyPalats);
        Mappable.mapIt(internetLine);
        Mappable.mapIt(water);

    }
}