package com.windowbutlers.backend.dto.requests;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PowerSourceLocationUpdateRequest {

    @Size(max = 100, message = "Power source location must be less then 100 characters")
    private String powerSourceLocation;
}
