package com.windowbutlers.backend.enums;

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

    public String getLabel() {
        return label;
    }
}
