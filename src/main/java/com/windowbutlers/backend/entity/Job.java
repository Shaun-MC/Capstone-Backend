package com.windowbutlers.backend.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class Job {

    private enum job_title {
        WINDOW_CLEANING("Window Cleaning"),
        GUTTER_CLEANING("Gutter Cleaning"),
        ROOF_CLEANING("Roof Cleaning"),
        MOSS_REMOVAL("Moss Removal"),
        HOLIDAY_LIGHT_INSTALLATION_AND_REMOVAL("Holiday Light Installation and Removal");

        private final String display_name;

        job_title(String displayName) {
            this.display_name = displayName;
        }

        @SuppressWarnings("unused")
        public String getDisplayName() {
            return display_name;
        }
    }

    private enum rating {
        
        VERY_EASY("Very Easy"),
        EASY("Easy"),
        MEDIUM("Medium"),
        HARD("Hard"),
        VERY_HARD("Very Hard");

        private final String display_rating;

        rating(String display_name) {
            this.display_rating = display_name;
        }

        @SuppressWarnings("unused")
        public String getDisplayName() {
            return display_rating;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("title")
    private job_title title;

    @JsonProperty("date_started")
    private Date date_started;

    @JsonProperty("date_completed")
    @Nullable
    private Date date_completed;

    @JsonProperty("labor_hours")
    private Integer labor_hours;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("difficulty")
    private rating difficulty;
}
