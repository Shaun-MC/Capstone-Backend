package com.windowbutlers.backend.dto.requests;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NotesUpdateRequest {

    @Size(max = 255, message = "Notes must be less then 255 characters")
    private String notes;
}
