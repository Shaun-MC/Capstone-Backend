package com.windowbutlers.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;
import com.windowbutlers.backend.validation.ValidUUID;

@Data
public class PaymentRequest {
    
    @NotNull(message = "Client ID is required")
    @ValidUUID(message = "Client ID must be a valid UUID")
    private UUID clientID;

    @DecimalMin(value = "0.01", message = "Payment amount must be greater than 0")
    private Double cost;
}
