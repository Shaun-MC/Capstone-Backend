package com.windowbutlers.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "job_style")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "jobID")
    private Job job;

    @JsonProperty("styleLabel")
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "styleLabel")
    private Styles styleLabel;

    // Only relevant for styles like "Windows" or "Trees"
    @Column(name = "large", nullable = true)
    private Integer large;

    @Column(name = "small", nullable = true)
    private Integer small;
}