package com.windowbutlers.backend.dto;

import com.windowbutlers.backend.validation.ValidEmail;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmailUpdateRequest {
    
    @NotNull(message = "Email is required")
    @ValidEmail(message = "Email must be valid")
    @Size(min = 2, max = 100, message = "Email must be between 2 and 100 characters")
    private String email;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}