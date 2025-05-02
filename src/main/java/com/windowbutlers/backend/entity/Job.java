package com.windowbutlers.backend.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "job")
public class Job {

    private enum job_title {
        WINDOW_CLEANING("Window Cleaning"),
        GUTTER_CLEANING("Gutter Cleaning"),
        ROOF_CLEANING("Roof Cleaning"),
        MOSS_REMOVAL("Moss Removal"),
        HOLIDAY_LIGHT_INSTALLATION_AND_REMOVAL("Holiday Light Installation and Removal");

        private final String title;

        job_title(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    private enum rating {
        
        VERY_EASY("Very Easy"),
        EASY("Easy"),
        MEDIUM("Medium"),
        HARD("Hard"),
        VERY_HARD("Very Hard");

        private final String rating;

        rating(String rating) {
            this.rating = rating;
        }

        public String getRating() {
            return rating;
        }
    }

        public String getRating() {
            return difficulty.getRating();
        }   

        public String getTitle() {
            return title.getTitle();
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
    @Nullable
    private Integer labor_hours;

    @JsonProperty("notes")
    @Nullable
    private String notes;

    @JsonProperty("difficulty")
    private rating difficulty;

    // Foreign key to the home table
    @JsonProperty("home_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "home", referencedColumnName = "id")
    private Integer home_id;
}
