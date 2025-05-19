package com.windowbutlers.backend.dto.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LaborHoursUpdateRequest {
    
    @NotNull(message = "Labor hours are required")
    @Min(value=0, message = "Labor hours must be a positive integer")
    private Integer laborHours;
}
