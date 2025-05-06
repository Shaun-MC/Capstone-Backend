package com.windowbutlers.backend.dto;

import com.windowbutlers.backend.validation.ValidEnum;
import com.windowbutlers.backend.enums.StyleLabel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class StyleRequest {
    
    @NotBlank(message = "Job ID is required")
    private Integer jobID;

    @NotBlank(message = "Style label is required")
    @ValidEnum(enumClass = StyleLabel.class)
    private String styleLabel;

    @Min(value=-1, message = "Large count must be a positive integer")
    private Integer large;

    @Min(value=-1, message = "Small count must be a positive integer")
    private Integer small;
}
