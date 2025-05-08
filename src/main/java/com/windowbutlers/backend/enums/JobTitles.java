package com.windowbutlers.backend.enums;

public enum JobTitles{
    WINDOW_CLEANING("Window Cleaning"),
    GUTTER_CLEANING("Gutter Cleaning"),
    ROOF_CLEANING("Roof Cleaning"),
    MOSS_REMOVAL("Moss Removal"),
    HOLIDAY_LIGHT_INSTALLATION_AND_REMOVAL("Holiday Light Installation and Removal");

    private final String title;

    JobTitles(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
