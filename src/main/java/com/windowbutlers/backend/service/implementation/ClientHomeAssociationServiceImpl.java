package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import com.windowbutlers.backend.repository.ClientHomeAssociationRepo;
import com.windowbutlers.backend.entity.ClientHomeKey;
import com.windowbutlers.backend.enums.RelationshipsToHome;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.validation.ValidUUID;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import java.util.List;
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

        clientHomeAssociation.setClientID(UUID.fromString(association.getClientID()));
        clientHomeAssociation.setHomeID(UUID.fromString(association.getHomeID()));
        clientHomeAssociation.setRelation(RelationshipsToHome.valueOf(association.getRelation()));
        
        chaRepo.save(clientHomeAssociation);

        return clientHomeAssociation.getRelation().toString();
    }

    @Override
    public List<ClientHomeAssociation> getHomesForClient(@ValidUUID String clientID) {
        
        return chaRepo.findHomeId_ByClientID(UUID.fromString(clientID));
    }

    @Override
    public List<ClientHomeAssociation> getClientsForHome(@ValidUUID String homeID) {
        return chaRepo.findClientId_ByHomeID(UUID.fromString(homeID));
    }

    @Override
    public String getAssociation(@ValidUUID String clientID, @ValidUUID String homeID) {
        
        return chaRepo.findByClientIDAndHomeID(UUID.fromString(clientID), UUID.fromString(homeID));
    }

    @Override
    public List<String> getAllAssociationsForHome(@ValidUUID String homeID) {
        
        return chaRepo.findAssociationsByHomeID(UUID.fromString(homeID));
    }

    @Override
    public void updateAssociation(@ValidUUID String clientID, @ValidUUID String homeID, String relation) {
        
        ClientHomeAssociation clientHomeAssociation = chaRepo.findById(new ClientHomeKey(UUID.fromString(clientID), UUID.fromString(homeID)))
                .orElseThrow(() -> new DataNotFoundException("UpdateAssociation: Association not found in the database"));
        
        clientHomeAssociation.setRelation(RelationshipsToHome.valueOf(relation));
        chaRepo.save(clientHomeAssociation);
    }

    @Override
    public void deleteAssociation(@ValidUUID String clientID, @ValidUUID String homeID) {
        
        chaRepo.deleteById(new ClientHomeKey(UUID.fromString(clientID), UUID.fromString(homeID)));
    }
}

