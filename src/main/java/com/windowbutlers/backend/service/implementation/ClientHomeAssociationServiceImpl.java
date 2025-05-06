package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import com.windowbutlers.backend.repository.ClientHomeAssociationRepo;
import com.windowbutlers.backend.entity.ClientHomeKey;
import com.windowbutlers.backend.enums.RelationshipToHome;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.validation.ValidIntegerID;
import com.windowbutlers.backend.validation.ValidUUID;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ClientHomeAssociationServiceImpl implements ClientHomeAssociationService {

    private final ClientHomeAssociationRepo chaRepo;

    public ClientHomeAssociationServiceImpl(ClientHomeAssociationRepo chaRepo) {
        this.chaRepo = chaRepo;
    }

    @Override
    public String createAssociation(@Valid ClientHomeAssociationRequest association) {
        
        ClientHomeAssociation clientHomeAssociation = new ClientHomeAssociation();

        clientHomeAssociation.setClientID(association.getClientID());
        clientHomeAssociation.setHomeID(association.getHomeID());
        clientHomeAssociation.setRelation(RelationshipToHome.valueOf(association.getRelation()));
        
        chaRepo.save(clientHomeAssociation);

        return clientHomeAssociation.getRelation().toString();
    }

    @Override
    public List<ClientHomeAssociation> getHomesForClient(@ValidUUID String clientID) {
        
        return chaRepo.findByClientID(UUID.fromString(clientID));
    }

    @Override
    public List<ClientHomeAssociation> getClientsForHome(@ValidIntegerID Integer homeID) {
        return chaRepo.findByHomeID(homeID);
    }

    @Override
    public String getAssociation(@ValidUUID String clientID, @ValidIntegerID Integer homeID) {
        
        return chaRepo.findByClientIDAndHomeID(UUID.fromString(clientID), homeID);
    }

    @Override
    public List<String> getAllAssociationsForHome(@ValidIntegerID Integer homeID) {
        
        return chaRepo.findAssociationsByHomeID(homeID);
    }

    @Override
    public void updateAssociation(@ValidUUID String clientID, @ValidIntegerID Integer homeID, String relation) {
        
        ClientHomeAssociation clientHomeAssociation = chaRepo.findById(new ClientHomeKey(UUID.fromString(clientID), homeID))
                .orElseThrow(() -> new DataNotFoundException("UpdateAssociation: Association not found in the database"));
        
        clientHomeAssociation.setRelation(RelationshipToHome.valueOf(relation));
        chaRepo.save(clientHomeAssociation);
    }

    @Override
    public void deleteAssociation(@ValidUUID String clientID, @ValidIntegerID Integer homeID) {
        
        chaRepo.deleteById(new ClientHomeKey(UUID.fromString(clientID), homeID));
    }
}

