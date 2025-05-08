package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.JobTitles;
import com.windowbutlers.backend.enums.JobRatings;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", name="id", updatable = false, nullable = false)
    @NotNull
    private UUID id;

    @JsonProperty("title")
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private JobTitles title;

    @JsonProperty("dateStarted")
    @NotNull
    @Column(name="date_started", nullable = false)
    private Date dateStarted;

    @JsonProperty("dateCompleted")
    @Column(name="date_completed", nullable = true)
    private Date dateCompleted;

    @JsonProperty("laborHours")
    @Column(name="labor_hours", nullable = true)
    private Integer laborHours;

    @JsonProperty("notes")
    @Column(nullable = true)
    private String notes;

    @JsonProperty("difficulty")
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable=false)
    private JobRatings difficulty;

    // Foreign key to the home table
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "home", referencedColumnName = "id", nullable = false)
    private Homes home;

    // Foreign key to the payment table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment", referencedColumnName = "id")
    @Column(nullable = true)
    private Payments payment; // Ehh

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChristmasLights> lights;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Styles> jobStyles;

    @Transient
    public boolean isPaid() {
        return this.payment != null;
    }
}
