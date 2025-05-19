package com.windowbutlers.backend.dto;

import com.windowbutlers.backend.enums.LightColors;
import com.windowbutlers.backend.validation.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChristmasLightsRequest {
    
    @Size(max = 255, message = "Storage location must be less then 255 characters")
    private String storageLocation;

    @NotNull(message = "In use is required")
    private Boolean inUse; 

    @NotBlank(message = "Color is required")
    @ValidEnum(enumClass = LightColors.class)
    private String color;
}
