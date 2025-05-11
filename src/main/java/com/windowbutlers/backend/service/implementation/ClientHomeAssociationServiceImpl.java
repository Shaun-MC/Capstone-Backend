package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import com.windowbutlers.backend.repository.ClientHomeAssociationRepo;
import com.windowbutlers.backend.entity.ClientHomeKey;
import com.windowbutlers.backend.enums.RelationshipsToHome;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
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
    public String createAssociation(ClientHomeAssociationRequest association) {
        
        ClientHomeAssociation clientHomeAssociation = new ClientHomeAssociation();

        clientHomeAssociation.setClientID(UUID.fromString(association.getClientID()));
        clientHomeAssociation.setHomeID(UUID.fromString(association.getHomeID()));
        clientHomeAssociation.setRelation(RelationshipsToHome.valueOf(association.getRelation()));
        
        chaRepo.save(clientHomeAssociation);

        return clientHomeAssociation.getRelation().toString();
    }

    @Override
    public List<ClientHomeAssociation> getHomesForClient(UUID clientID) {
        
        return chaRepo.findHomeId_ByClientID(clientID);
    }

    @Override
    public List<ClientHomeAssociation> getClientsForHome(UUID homeID) {
        return chaRepo.findClientId_ByHomeID(homeID);
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
    public void updateAssociation(UUID clientID, UUID homeID, String relation) {
        
        ClientHomeAssociation clientHomeAssociation = chaRepo.findById(new ClientHomeKey(clientID, homeID))
                .orElseThrow(() -> new DataNotFoundException("UpdateAssociation: Association not found in the database"));
        
        clientHomeAssociation.setRelation(RelationshipsToHome.valueOf(relation));
        chaRepo.save(clientHomeAssociation);
    }

    @Override
    public void deleteAssociation(UUID clientID, UUID homeID) {
        
        if (!chaRepo.existsById(new ClientHomeKey(clientID, homeID))) {
            throw new DataNotFoundException("DeleteAssociation: Association not found in the database");
        }
        chaRepo.deleteById(new ClientHomeKey(clientID, homeID));
    }
}

