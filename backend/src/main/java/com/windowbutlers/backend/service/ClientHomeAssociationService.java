package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.ClientHomeAssociationDTO;
import com.windowbutlers.backend.dto.requests.ClientHomeAssociationRequest;
import com.windowbutlers.backend.dto.requests.RelationshipUpdateRequest;
import com.windowbutlers.backend.dto.responses.AssociationResponse;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ClientHomeAssociationService {

    AssociationResponse createAssociation(ClientHomeAssociationRequest association);

    List<ClientHomeAssociationDTO> getAllAssociations();

    List<ClientHomeAssociationDTO> getHomesForClient(UUID clientID);

    List<ClientHomeAssociationDTO> getClientsForHome(UUID homeID);

    List<String> getAllAssociationsForHome(UUID homeID);
    
    AssociationResponse getAssociation(UUID clientID, UUID homeID);

    SuccessfulUpdateResponse updateAssociation(UUID clientID, UUID homeID, RelationshipUpdateRequest relation);

    DeleteMessageResponse deleteAssociation(UUID clientID, UUID homeID);
}