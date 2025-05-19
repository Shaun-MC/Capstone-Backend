package com.windowbutlers.backend.dto.requests;

import com.windowbutlers.backend.enums.RelationshipsToHome;
import com.windowbutlers.backend.validation.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RelationshipUpdateRequest {
    
    @NotBlank(message = "Relation is required")
    @ValidEnum(enumClass = RelationshipsToHome.class)
    private String relationship;
}
