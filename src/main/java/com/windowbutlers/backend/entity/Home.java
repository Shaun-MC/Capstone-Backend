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
    private Integer ID;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("pictureDirectoryURL")
    @Column(nullable=true, unique=true)
    private String pictureDirectoryURL;

    @JsonProperty("addressLine1")
    @NotNull
    private String addressLine1;

    @JsonProperty("addressLine2")
    @Column(nullable = true)
    private String addressLine2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("powerSourceLocation")
    @Column(nullable = true)
    private String powerSourceLocation;
}
