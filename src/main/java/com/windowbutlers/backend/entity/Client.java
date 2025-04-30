package com.windowbutlers.backend.entity;

// Removed duplicate import

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

//@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Client")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("email")
    @Nullable
    @Column(unique=true)
    private String email; 

    @JsonProperty("phone_number")
    @Nullable
    @Column(unique=true)
    private String phone_number;

    @JsonProperty("has_own_lights")
    @Nullable
    private Boolean has_own_lights;
}
