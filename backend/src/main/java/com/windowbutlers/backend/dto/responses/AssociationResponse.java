package com.windowbutlers.backend.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssociationResponse {
    
    @JsonProperty("message")
    private String message;

    public AssociationResponse(String message) {
        this.message = message;
    }
}
