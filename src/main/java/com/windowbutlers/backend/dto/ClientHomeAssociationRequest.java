package com.windowbutlers.backend.dto;

import com.windowbutlers.backend.enums.RelationshipToHome;
import com.windowbutlers.backend.validation.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientHomeAssociationRequest {
    
    @NotNull(message = "Client ID is required")
    private Integer clientID;

    @NotNull(message = "Home ID is required")
    private Integer homeID;

    @NotBlank(message = "Relation is required")
    @ValidEnum(enumClass = RelationshipToHome.class)
    private String relation;
}
