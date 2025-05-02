package com.windowbutlers.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @JsonProperty("first_name")
    @NotNull
    private String first_name;

    @JsonProperty("last_name")
    @NotNull
    private String last_name;

    @JsonProperty("email")
    @Column(nullable=true, unique=true)
    private String email; 

    @JsonProperty("phone_number")
    @Column(nullable=true, unique=true)
    private String phone_number;

    @JsonProperty("has_own_lights")
    @Column(nullable=true)
    private Boolean has_own_lights;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @Column(nullable=true)
    private List<Payment> payments;
}
