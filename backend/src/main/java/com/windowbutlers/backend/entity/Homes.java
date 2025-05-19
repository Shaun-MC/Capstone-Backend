package com.windowbutlers.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "homes")
public class Homes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @JsonProperty("notes")
    @Column(nullable=true)
    private String notes;

    @JsonProperty("pictureDirectoryURL")
    @Column(name = "picture_directory_url", nullable = true, unique = true)
    private String pictureDirectoryURL;

    @JsonProperty("addressLine1")
    @NotNull
    @Column(name="address_line_1", nullable=false)
    private String addressLine1;

    @JsonProperty("addressLine2")
    @Column(name="address_line_2", nullable = true)
    private String addressLine2;

    @JsonProperty("city")
    @NotNull
    @Column(nullable = false)
    private String city;

    @JsonProperty("zipCode")
    @NotNull
    @Column(name="zip_code", nullable = false)
    private String zipCode;

    @JsonProperty("powerSourceLocation")
    @Column(name="power_source_location", nullable = true)
    private String powerSourceLocation;

    @JsonManagedReference
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jobs> jobs;
}
