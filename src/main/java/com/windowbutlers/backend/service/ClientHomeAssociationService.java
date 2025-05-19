package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.dto.ClientHomeAssociationDTO;
import com.windowbutlers.backend.dto.RelationshipUpdateRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ClientHomeAssociationService {

    String createAssociation(ClientHomeAssociationRequest association);

    List<ClientHomeAssociationDTO> getAllAssociations();

    List<ClientHomeAssociationDTO> getHomesForClient(UUID clientID);

    List<ClientHomeAssociationDTO> getClientsForHome(UUID homeID);

    String getAssociation(UUID clientID, UUID homeID);

    List<String> getAllAssociationsForHome(UUID homeID);

    String updateAssociation(UUID clientID, UUID homeID, RelationshipUpdateRequest relation);

    void deleteAssociation(UUID clientID, UUID homeID);
}