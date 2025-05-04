package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.JobTitle;
import com.windowbutlers.backend.enums.Rating;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;
import java.sql.Date;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @JsonProperty("title")
    @Enumerated(EnumType.STRING)
    @NotNull
    private JobTitle title;

    @JsonProperty("date_started")
    @NotNull
    private Date date_started;

    @JsonProperty("date_completed")
    @Column(nullable = true)
    private Date date_completed;

    @JsonProperty("labor_hours")
    @Column(nullable = true)
    private Integer labor_hours;

    @JsonProperty("notes")
    @Column(nullable = true)
    private String notes;

    @JsonProperty("difficulty")
    @Enumerated(EnumType.STRING)
    private Rating difficulty;

    // Foreign key to the home table
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "home", referencedColumnName = "id")
    private Home home;

    // Foreign key to the payment table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment", referencedColumnName = "id")
    @Column(nullable = true)
    private Payment payment;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChristmasLighting> lights;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Style> jobStyles;

    @Transient
    public boolean isPaid() {
        return this.payment != null;
    }
}
