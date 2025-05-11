package com.windowbutlers.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StyleLabels {
    
    FRONT("Front"),
    BACK("Back"),
    LEFT("Left"),
    RIGHT("Right"),
    CENTER("Center"),
    FULL_WRAP("Full Wrap"),
    RIDGES("Ridges"),
    ENTIRE_HOUSE("Entire House"),
    PEAKS("Peaks"),
    ACROSS_PEAKS("Across Peaks"),
    POLES("Poles"),
    GARAGE("Garage"),
    WINDOWS("Windows"),
    TREES("Trees");

    private final String label;

    StyleLabels(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static StyleLabels fromString(String value) {
        for (StyleLabels style : StyleLabels.values()) {
            if (style.label.equalsIgnoreCase(value) || style.name().equalsIgnoreCase(value)) {
                return style;
            }
        }
        throw new IllegalArgumentException("Invalid StyleLabel: " + value);
    }
}
