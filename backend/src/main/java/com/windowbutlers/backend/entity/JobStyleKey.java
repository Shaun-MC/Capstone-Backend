package com.windowbutlers.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobStyleKey implements Serializable {
    
    @Column(name = "job_id")
    @NotNull
    private Integer jobID;

    @Column(name = "style_id")
    @NotNull
    private Integer styleID;

    // Not necessary to implement - don't want to run into issues w/ out them
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof JobStyleKey))
            return false;
        JobStyleKey that = (JobStyleKey) o;
        return Objects.equals(jobID, that.jobID) && Objects.equals(styleID, that.styleID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobID, styleID);
    }
}
