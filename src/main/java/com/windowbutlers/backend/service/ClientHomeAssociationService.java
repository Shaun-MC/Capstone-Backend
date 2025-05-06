package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.validation.ValidIntegerID;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface ClientHomeAssociationService {

    String createAssociation(@Valid ClientHomeAssociationRequest association);

    List<ClientHomeAssociation> getHomesForClient(@ValidUUID String clientID);

    List<ClientHomeAssociation> getClientsForHome(@ValidIntegerID Integer homeID);

    String getAssociation(@ValidUUID String clientID, @ValidIntegerID Integer homeID);

    List<String> getAllAssociationsForHome(@ValidIntegerID Integer homeID);

    void updateAssociation(@ValidUUID String clientID, @ValidIntegerID Integer homeID, String relation);

    void deleteAssociation(@ValidUUID String clientID, @ValidIntegerID Integer homeID);
}