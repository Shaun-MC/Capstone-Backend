package com.windowbutlers.backend.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientHomeKey implements Serializable {

    @Column(name = "client_id", nullable = false, columnDefinition = "uuid")
    @NotNull
    private UUID client_id;

    @Column(name = "home_id", nullable = false)
    @NotNull
    private Integer home_id;

    // Not necessary to implement - don't want to run into issues w/ out them
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ClientHomeKey))
            return false;
        ClientHomeKey that = (ClientHomeKey) o;
        return Objects.equals(client_id, that.client_id) && Objects.equals(home_id, that.home_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_id, home_id);
    }
}
