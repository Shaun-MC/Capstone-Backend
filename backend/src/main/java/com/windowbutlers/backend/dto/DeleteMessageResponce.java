package com.windowbutlers.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteMessageResponce {
    
    @JsonProperty("message")
    private String message;

    public DeleteMessageResponce(String className) {
        this.message = String.format("%s object deleted successfully", className);
    }
}
