package com.windowbutlers.backend.enums;

public enum JobRatings {
        
    VERY_EASY("Very Easy"),
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    VERY_HARD("Very Hard");

    private final String rating;

    JobRatings(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }
}