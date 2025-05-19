package com.windowbutlers.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientHomeAssociationDTO {
    
    private UUID clientID;
    private UUID homeID;
    private String relationship;
}
