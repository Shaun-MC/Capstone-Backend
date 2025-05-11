package com.windowbutlers.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LightColors {
    
    COOL_WHITE("Cool White"),
    WARM_WHITE("Warm White"),
    BLUE("Blue"),
    RED("Red"),
    GREEN("Green"),
    PURPLE("Purple"),
    MULTI_COLOR("Multi-Color"); 
    
    private final String displayColor;

    LightColors(String color) {
        this.displayColor = color;
    }

    @JsonValue
    public String getColor() {
        return this.displayColor;
    }

    @JsonCreator
    public static LightColors fromString(String value) {
        for (LightColors color : LightColors.values()) {
            if (color.displayColor.equalsIgnoreCase(value) || color.name().equalsIgnoreCase(value)) {
                return color;
            }
        }
        throw new IllegalArgumentException("Invalid LightColor: " + value);
    }
}
