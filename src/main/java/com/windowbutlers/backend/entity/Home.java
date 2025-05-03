package com.windowbutlers.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
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
    @Column(nullable=true, unique=true)
    private String picture_directory_url;

    @JsonProperty("address_line_1")
    @NotNull
    private String address_line_1;

    @JsonProperty("address_line_2")
    @Column(nullable = true)
    private String address_line_2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip_code")
    private String zip_code;

    @JsonProperty("power_source_location")
    @Column(nullable = true)
    private String power_source_location;
}
