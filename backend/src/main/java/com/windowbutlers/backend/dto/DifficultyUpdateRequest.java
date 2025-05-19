package com.windowbutlers.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DifficultyUpdateRequest {
    
    @NotNull(message = "Job difficulty is required")
    private String difficulty;
}
