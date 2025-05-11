package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.entity.ClientHomeAssociation;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ClientHomeAssociationService {

    String createAssociation(ClientHomeAssociationRequest association);

    List<ClientHomeAssociation> getHomesForClient(UUID clientID);

    List<ClientHomeAssociation> getClientsForHome(UUID homeID);

    String getAssociation(UUID clientID, UUID homeID);

    List<String> getAllAssociationsForHome(UUID homeID);

    void updateAssociation(UUID clientID, UUID homeID, String relation);

    void deleteAssociation(UUID clientID, UUID homeID);
}