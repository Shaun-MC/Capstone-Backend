package com.windowbutlers.backend.dto;

import com.windowbutlers.backend.validation.ValidPhoneNumber;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PhoneNumberUpdateRequest {

    @NotNull(message = "Phone number is required")
    @ValidPhoneNumber(message = "Phone number is in an invalid format")
    @Size(min = 12, max = 12, message = "Phone number must 12 characters. EX: '123-456-7890'")
    private String phoneNumber;
}
