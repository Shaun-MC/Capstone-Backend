package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.JobTitle;
import com.windowbutlers.backend.enums.Rating;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("title")
    private JobTitle title;

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
    private Rating difficulty;

    // Foreign key to the home table
    @JsonProperty("home_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "home", referencedColumnName = "id")
    private Home home_id;
}
