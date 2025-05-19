package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.LightColors;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;

/**
 * TODO:
 * Doesn't really make sense for inUse to be true and not associated with a job.
 */
@Entity
@Table(name = "christmas_lights")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChristmasLights {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @JsonProperty("storageLocation")
    @NotNull
    @Column(name = "storage_location", nullable = false)
    private String storageLocation;

    @JsonProperty("inUse")
    @NotNull
    @Column(name = "in_use", nullable = false)
    private Boolean inUse;

    @JsonProperty("color")
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private LightColors color;

    @JsonProperty("jobID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = true)
    private Jobs job;
}
