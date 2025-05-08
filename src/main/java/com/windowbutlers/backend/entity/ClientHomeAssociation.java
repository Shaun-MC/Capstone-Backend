package com.windowbutlers.backend.entity;

import com.windowbutlers.backend.enums.RelationshipsToHome;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "clients_to_homes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientHomeAssociation {

    @EmbeddedId
    private ClientHomeKey id;

    @ManyToOne
    @MapsId("clientID")
    @JoinColumn(name = "client", referencedColumnName = "id")
    @Column(name = "client_id", nullable = false)
    @NotNull
    private Clients client;

    @ManyToOne
    @MapsId("homeID")
    @JoinColumn(name = "homeID")
    @Column(name = "home_id", nullable = false)
    @NotNull
    private Homes home;

    @JsonProperty("relation")
    @NotNull
    private RelationshipsToHome relation;

    public void setClientID(UUID clientID) {
        if (this.id == null) {
            this.id = new ClientHomeKey();
        }
        this.id.setClientID(clientID);
    }
    
    public void setHomeID(UUID homeID) {
        if (this.id == null) {
            this.id = new ClientHomeKey();
        }
        this.id.setHomeID(homeID);
    }
}
