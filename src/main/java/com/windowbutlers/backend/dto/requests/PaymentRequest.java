package com.windowbutlers.backend.dto.requests;

import com.windowbutlers.backend.validation.ValidUUID;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PaymentRequest {
    
    @NotNull(message = "Client ID is required")
    @ValidUUID(message = "Client ID must be a valid UUID")
    private String clientID;

    @DecimalMin(value = "0.01", message = "Payment amount must be greater than 0")
    private Double cost;
}
