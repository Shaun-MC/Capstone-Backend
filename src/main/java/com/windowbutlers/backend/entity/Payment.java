package com.windowbutlers.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    // Foreign key to the job table
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client", referencedColumnName = "client")
    private Client client;

    @JsonProperty("cost")
    @NotNull
    @Column(nullable = false)
    private Double cost;

    @OneToMany(mappedBy = "payment")
    private List<Job> jobs;

    public boolean isFullfilled() {
        return jobs != null && jobs.stream().allMatch(Job::isPaid);
    }
}
