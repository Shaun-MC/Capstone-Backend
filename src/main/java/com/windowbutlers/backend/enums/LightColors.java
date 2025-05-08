package com.windowbutlers.backend.enums;

public enum LightColors {
    
    COOL_WHITE("Cool White"),
    WARM_WHITE("Warm White"),
    BLUE("Blue"),
    RED("Red"),
    GREEN("Green"),
    PURPLE("Purple"),
    MULTI_COLOR("Multi-Color"); 
    
    private final String color;

    LightColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
