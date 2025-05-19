package com.windowbutlers.backend.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StorageLocationUpdateRequest {
    
    @NotBlank(message = "Storage location is required")
    @Size(max = 255, message = "Storage location must be less than 255 characters")
    private String storageLocation;
}
