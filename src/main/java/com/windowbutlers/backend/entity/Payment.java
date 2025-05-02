package com.windowbutlers.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    public boolean isFulfilled() {
        return jobs != null && jobs.stream().allMatch(Job::isPaid);
    }

}
