package com.windowbutlers.backend.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@Table(name = "home")
public class Home {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("picture_directory_url")
    @Nullable
    @Column(unique=true)
    private String picture_directory_url;

    @JsonProperty("address_line_1")
    private String address_line_1;

    @JsonProperty("address_line_2")
    @Nullable
    private String address_line_2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip_code")
    private String zip_code;

    @JsonProperty("power_source_location")
    @Nullable
    private String power_source_location;
}
