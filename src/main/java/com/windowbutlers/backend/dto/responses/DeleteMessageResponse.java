package com.windowbutlers.backend.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteMessageResponse {
    
    @JsonProperty("message")
    private String message;

    public DeleteMessageResponse(String className) {
        this.message = String.format("%s object deleted successfully", className);
    }
}
