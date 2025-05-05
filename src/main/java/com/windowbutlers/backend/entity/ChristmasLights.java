package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.LightColor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "christmas_lights")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChristmasLights {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID ID;

    @JsonProperty("storageLocation")
    @NotNull
    private String storageLocation;

    @JsonProperty("inUse")
    @NotNull
    private Boolean inUse;

    @Enumerated(EnumType.STRING)
    private LightColor color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobID", nullable = true)
    private Job job;
}
