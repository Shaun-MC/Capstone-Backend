package com.windowbutlers.backend.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessfulUpdateResponse {
    
    @JsonProperty("message")
    private String message;

    public SuccessfulUpdateResponse(String property) {
        this.message = String.format("%s property updated successfully", property);
    }
}
