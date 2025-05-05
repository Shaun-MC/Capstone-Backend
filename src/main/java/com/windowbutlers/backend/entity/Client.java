package com.windowbutlers.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
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
    private UUID ID;

    @JsonProperty("firstName")
    @NotNull
    private String firstName;

    @JsonProperty("lastName")
    @NotNull
    private String lastName;

    @JsonProperty("email")
    @Column(nullable=true, unique=true)
    private String email; 

    @JsonProperty("phone_number")
    @Column(nullable=true, unique=true)
    private String phoneNumber;

    @JsonProperty("hasOwnLights")
    @Column(nullable=true)
    private Boolean hasOwnLights;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @Column(nullable=true)
    private List<Payment> payments;
}
