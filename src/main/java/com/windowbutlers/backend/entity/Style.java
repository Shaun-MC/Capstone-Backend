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
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "job_id")
    private Job job;

    @JsonProperty("style_label")
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "style_label")
    private Styles style_label;

    // Only relevant for styles like "Windows" or "Trees"
    @Column(name = "count_large", nullable = true)
    private Integer count_large;

    @Column(name = "count_small", nullable = true)
    private Integer count_small;
}