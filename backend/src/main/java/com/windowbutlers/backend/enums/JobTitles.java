package com.windowbutlers.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobTitles {
    WINDOW_CLEANING("Window Cleaning"), GUTTER_CLEANING("Gutter Cleaning"), ROOF_CLEANING("Roof Cleaning"), MOSS_REMOVAL("Moss Removal"),
    HOLIDAY_LIGHT_INSTALLATION_AND_REMOVAL("Holiday Light Installation and Removal");

    private final String displayTitle;

    JobTitles(String title) {
        this.displayTitle = title;
    }

    @JsonValue
    public String getTitle() {
        return displayTitle;
    }

    @JsonCreator
    public static JobTitles fromString(String value) {
        for (JobTitles title : JobTitles.values()) {
            if (title.displayTitle.equalsIgnoreCase(value) || title.name().equalsIgnoreCase(value)) {
                return title;
            }
        }
        throw new IllegalArgumentException("Invalid JobTitle: " + value);
    }
}
