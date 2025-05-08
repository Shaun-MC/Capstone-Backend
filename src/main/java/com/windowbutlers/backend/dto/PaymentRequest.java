package com.windowbutlers.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;

@Data
public class PaymentRequest {
    
    @NotNull(message = "Client ID is required")
    private UUID clientID;

    @NotNull(message = "Payment amount is required")
    @DecimalMin(value = "0.01", message = "Payment amount must be greater than 0")
    private Double cost;
}
