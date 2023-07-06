package com.gmail.mekhanich.andrii;

enum UtilityType {ELECTRICAL, FIBER_OPTIC, WATER_PIPES}
public class UtilityLine implements Mappable{

    private String name;
    private UtilityType type;
    private Color color;
    private LineMarker point;
    private Geometry geometry = Geometry.LINE;

    public UtilityLine(String name, UtilityType type, Color color, LineMarker point) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.point = point;
    }

    @Override
    public String getName() {
        return name;
    }


    public String getType() {
        return type.toString();
    }

    @Override
    public String getLabel() {
        String message = "label: "+ "\"" + name + " (" + type + ")";
        return message;
    }

    @Override
    public String getMarker() {
        String message = "marker: "+ color.toString() + " " + point.toString();
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

    @Override
    public String toJSON() {
        return Mappable.super.toJSON();
    }
}
