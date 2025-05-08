package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface ClientHomeAssociationService {

    String createAssociation(@Valid ClientHomeAssociationRequest association);

    List<ClientHomeAssociation> getHomesForClient(@ValidUUID String clientID);

    List<ClientHomeAssociation> getClientsForHome(@ValidUUID String homeID);

    String getAssociation(@ValidUUID String clientID, @ValidUUID String homeID);

    List<String> getAllAssociationsForHome(@ValidUUID String homeID);

    void updateAssociation(@ValidUUID String clientID, @ValidUUID String homeID, String relation);

    void deleteAssociation(@ValidUUID String clientID, @ValidUUID String homeID);
}