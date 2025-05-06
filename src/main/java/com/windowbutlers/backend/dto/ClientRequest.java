package com.windowbutlers.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 255, message = "First name must be between 2 and 255 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 255, message = "Last name must be between 2 and 255 characters")
    private String lastName;

    @Email(message = "Email must be valid")
    @Size(min = 2, max = 255, message = "Last name must be between 2 and 255 characters")
    private String email;

    @Pattern(
        regexp = "^[+]?[0-9\\-\\s]*$",
        message = "Phone number must be valid"
    )
    @Size(min = 2, max = 255, message = "Last name must be between 2 and 255 characters")
    private String phoneNumber;

    private Boolean hasOwnLights;
}
