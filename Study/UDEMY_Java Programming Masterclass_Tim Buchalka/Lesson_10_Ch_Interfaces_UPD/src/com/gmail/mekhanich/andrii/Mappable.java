package com.gmail.mekhanich.andrii;

enum Geometry {LINE, POINT, POLYGON}
enum PointMarker {CIRCLE, STAR, PIN}
enum LineMarker {DOTTED, DASHED, SOLID}
enum Color {RED, ORANGE, YELLOW, GREEN, GRAY, BLUE, VIOLETTE, BLACK, WHITE}

public interface Mappable {
    String JSON_PROPERTY = """
                        "properties":{ %s }
                    """;

    static void mapIt(Mappable mappable){
            String result = JSON_PROPERTY.formatted(mappable.toJSON());
            System.out.println(result);
    };
    default String toJSON() {
        return """
                "type":"%s", "label:"%s", "marker":"%s", "name":"%s", "usage":"%s" """.formatted(getShape(), getLabel(), getMarker(), getName(), getUsage());

                }
    String getName();
    String getLabel();
    String getMarker();
    Geometry getShape();
    String getUsage();

}
