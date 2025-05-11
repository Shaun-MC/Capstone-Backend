package com.windowbutlers.backend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class CostUpdateRequest {

    @NotNull(message = "Payment amount is required")
    @DecimalMin(value = "0.01", message = "Payment amount must be greater than 0")
    private Double cost;

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }
}
