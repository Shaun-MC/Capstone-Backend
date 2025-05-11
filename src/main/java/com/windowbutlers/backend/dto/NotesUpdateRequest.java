package com.windowbutlers.backend.dto;

import jakarta.validation.constraints.Size;

public class NotesUpdateRequest {

    @Size(max = 255, message = "Notes must be less then 255 characters")
    private String notes;

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
