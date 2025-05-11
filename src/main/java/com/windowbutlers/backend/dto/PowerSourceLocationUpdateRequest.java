package com.windowbutlers.backend.dto;

import jakarta.validation.constraints.Size;

public class PowerSourceLocationUpdateRequest {

    @Size(max = 100, message = "Power source location must be less then 100 characters")
    private String powerSourceLocation;

    public String getPowerSourceLocation() {
        return powerSourceLocation;
    }

    public void setPowerSourceLocation(String powerSourceLocation) {
        this.powerSourceLocation = powerSourceLocation;
    }
}
