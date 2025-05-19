package com.windowbutlers.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobRatings {
        
    VERY_EASY("Very Easy"),
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    VERY_HARD("Very Hard");

    private final String displayRating;

    JobRatings(String rating) {
        this.displayRating = rating;
    }

    @JsonValue
    public String getRating() {
        return displayRating;
    }

    @JsonCreator
    public static JobRatings fromString(String value) {
        for (JobRatings rating : JobRatings.values()) {
            if (rating.displayRating.equalsIgnoreCase(value) || rating.name().equalsIgnoreCase(value)) {
                return rating;
            }
        }
        throw new IllegalArgumentException("Invalid JobTitle: " + value);
    }
}