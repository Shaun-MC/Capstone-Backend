package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.dto.RelationshipUpdateRequest;
import com.windowbutlers.backend.dto.ClientHomeAssociationDTO;
import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.entity.Clients;
import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import com.windowbutlers.backend.repository.ClientHomeAssociationRepo;
import com.windowbutlers.backend.repository.ClientRepo;
import com.windowbutlers.backend.repository.HomeRepo;
import com.windowbutlers.backend.entity.ClientHomeKey;
import com.windowbutlers.backend.enums.RelationshipsToHome;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class ClientHomeAssociationServiceImpl implements ClientHomeAssociationService {

    private final ClientHomeAssociationRepo chaRepo;
    private final ClientRepo clientRepo;
    private final HomeRepo homeRepo;

    public ClientHomeAssociationServiceImpl(ClientHomeAssociationRepo chaRepo, 
                                            ClientRepo clientRepo, 
                                            HomeRepo homeRepo) {
        this.chaRepo = chaRepo;
        this.clientRepo = clientRepo;
        this.homeRepo = homeRepo;
    }

    @Override
    // This sucks
    public String createAssociation(ClientHomeAssociationRequest req) {
        
        UUID clientUUID = UUID.fromString(req.getClientID());
        UUID homeUUID = UUID.fromString(req.getHomeID());

        ClientHomeKey key = new ClientHomeKey(clientUUID, homeUUID);

        if (chaRepo.existsById(key)) {
            throw new DataNotFoundException("Association already exists for this client and home.");
        }

        ClientHomeAssociation clientHomeAssociation = new ClientHomeAssociation();

        Clients client = clientRepo.findById(clientUUID)
                .orElseThrow(() -> new DataNotFoundException("CreateAssociation: Client ID not found in the database"));
        Homes home = homeRepo.findById(homeUUID)
            .orElseThrow(() -> new DataNotFoundException("CreateAssociation: Home ID not found in the database"));

        clientHomeAssociation.setClientID(clientUUID, client);
        clientHomeAssociation.setHomeID(homeUUID, home);
        clientHomeAssociation.setRelationship(RelationshipsToHome.fromString(req.getRelationship()));

        chaRepo.save(clientHomeAssociation);

        return clientHomeAssociation.getId().toString();
    }

    @Override
    public List<ClientHomeAssociationDTO> getAllAssociations() {
        List<ClientHomeAssociation> entities = chaRepo.findAll();
        // Doesn't feel right
        return entities.stream().map(cha -> new ClientHomeAssociationDTO(
            cha.getClient().getId(),
            cha.getHome().getId(),
            cha.getRelationship().getRelationship()
        )).toList();
    }

    @Override
    public List<ClientHomeAssociationDTO> getHomesForClient(UUID clientID) {
        List<ClientHomeAssociation> entities = chaRepo.findHomeIDByClientID(clientID);
        // Doesn't feel right
        return entities.stream().map(cha -> new ClientHomeAssociationDTO(
            cha.getClient().getId(),
            cha.getHome().getId(),
            cha.getRelationship().getRelationship()
        )).toList();
    }

    @Override
    public List<ClientHomeAssociationDTO> getClientsForHome(UUID homeID) {
        List<ClientHomeAssociation> entities = chaRepo.findClientIDByHomeID(homeID);
        // Doesn't feel right
        return entities.stream().map(cha -> new ClientHomeAssociationDTO(
            cha.getClient().getId(),
            cha.getHome().getId(),
            cha.getRelationship().getRelationship()
        )).toList();
    }

    @Override
    public String getAssociation(UUID clientID, UUID homeID) {
        
        return chaRepo.findByClientIDAndHomeID(clientID, homeID);
    }

    @Override
    public List<String> getAllAssociationsForHome(UUID homeID) {
        
        return chaRepo.findAssociationsByHomeID(homeID);
    }

    @Override
    public String updateAssociation(UUID clientID, UUID homeID, RelationshipUpdateRequest req) {
        
        ClientHomeAssociation clientHomeAssociation = chaRepo.findById(new ClientHomeKey(clientID, homeID))
                .orElseThrow(() -> new DataNotFoundException("UpdateAssociation: Association not found in the database"));
        
        clientHomeAssociation.setRelationship(RelationshipsToHome.fromString(req.getRelationship()));
        chaRepo.save(clientHomeAssociation);

        return req.getRelationship();
    }

    @Override
    public void deleteAssociation(UUID clientID, UUID homeID) {
        
        if (!chaRepo.existsById(new ClientHomeKey(clientID, homeID))) {
            throw new DataNotFoundException("DeleteAssociation: Association not found in the database");
        }
        chaRepo.deleteById(new ClientHomeKey(clientID, homeID));
    }
}

