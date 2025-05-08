package com.windowbutlers.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    private String lastName;

    @Email(message = "Email must be valid")
    @Size(min = 2, max = 100, message = "Email must be between 2 and 100 characters")
    private String email;

    @Pattern(
        regexp = "^\\d{3}-\\d{3}-\\d{4}$",
        message = "Phone number must be valid"
    )
    @Size(min = 12, max = 12, message = "Phone number must 12 characters. EX: '123-456-7890'")
    private String phoneNumber;

    private Boolean hasOwnLights;
}
