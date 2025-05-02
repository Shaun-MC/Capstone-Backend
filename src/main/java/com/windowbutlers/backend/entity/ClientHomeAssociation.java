package com.windowbutlers.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.windowbutlers.backend.enums.RelationshipToHome;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientHomeAssociation {

    @EmbeddedId
    private ClientHomeKey id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    @NotNull
    private Client client;

    @ManyToOne
    @MapsId("homeId")
    @JoinColumn(name = "home_id")
    @NotNull
    private Home home;

    @JsonProperty("relation")
    @Column(name = "")
    @NotNull
    private RelationshipToHome relation;
}
