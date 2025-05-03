package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.RelationshipToHome;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "client_home_association")
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
