package com.windowbutlers.backend.dto.requests;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data

public class CountsUpdateRequest {
    
    @Min(value=-1, message = "Large count must be a positive integer")
    private Integer large;

    @Min(value=-1, message = "Small count must be a positive integer")
    private Integer small;
}
