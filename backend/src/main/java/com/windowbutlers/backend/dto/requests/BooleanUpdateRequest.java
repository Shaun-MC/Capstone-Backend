package com.windowbutlers.backend.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BooleanUpdateRequest {
    
    @NotNull(message = "Value is required")
    private Boolean value;
}
