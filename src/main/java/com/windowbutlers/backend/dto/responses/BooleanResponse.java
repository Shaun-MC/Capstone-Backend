package com.windowbutlers.backend.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class BooleanResponse {
    
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("value")
    private boolean value;
}
