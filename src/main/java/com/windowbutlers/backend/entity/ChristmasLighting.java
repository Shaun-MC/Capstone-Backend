package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.LightColor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "christmas_lighting")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChristmasLighting {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @JsonProperty("storage_location")
    @NotNull
    private String storage_location;

    @JsonProperty("in_use")
    @NotNull
    private Boolean in_use;

    @Enumerated(EnumType.STRING)
    private LightColor color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = true)
    private Job job;
}
