package com.gmail.mekhanich.andrii;

enum BuildingTypes {BUISNESS, ENTERTAINMENT, SERVICES, GOVERNMENT }

public class Building implements Mappable{

    private String name;
    private BuildingTypes type;
    private Color color;
    private PointMarker point;
    private Geometry geometry = Geometry.POINT;

    public Building(String name, BuildingTypes type, Color color, PointMarker point) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.point = point;
    }

    public String getType() {
        return type.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLabel() {
        String message = name + " (" + type + ")";
        return message;
    }

    @Override
    public String getMarker() {
        String message = color.toString() + " " + point.toString();
        return message;
    }

    @Override
    public Geometry getShape() {
        return geometry;
    }

    @Override
    public String getUsage() {
        return type.toString();
    }

//    @Override
//    public String toJSON() {
//        return Mappable.super.toJSON() +  """
//                , "name": "%s", "usage": "%s" """.formatted(name, type);
//    }
}
