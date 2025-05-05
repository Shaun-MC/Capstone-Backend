package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import com.windowbutlers.backend.repository.ClientHomeAssociationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ClientHomeAssociationServiceImpl implements ClientHomeAssociationService {

    @Autowired
    private ClientHomeAssociationRepo repo;

    @Override
    public ClientHomeAssociation SaveAssociation(ClientHomeAssociation association) {
        try {
            return repo.save(association);
        } catch (Exception e) {
            throw new RuntimeException("SaveAssociation: Error saving association: " + e.getMessage());
        }
    }

    @Override
    public List<ClientHomeAssociation> GetHomesForClient(UUID clientID) {
        try {
            return repo.findByClientID(clientID);
        } catch (Exception e) {
            throw new RuntimeException("GetHomesForClient: Error retrieving homes for client: " + e.getMessage());
        }
    }

    @Override
    public List<ClientHomeAssociation> GetClientsForHome(Integer homeID) {
        try {
            return repo.findByHomeID(homeID);
        } catch (Exception e) {
            throw new RuntimeException("GetClientsForHome: Error retrieving clients for home: " + e.getMessage());
        }
    }

    @Override
    public Optional<ClientHomeAssociation> GetAssociation(UUID clientID, Integer homeID) {
        try {
            return repo.findByClientIDAndHomeID(clientID, homeID);
        } catch (Exception e) {
            throw new RuntimeException("GetAssociation: Error retrieving association: " + e.getMessage());
        }
    }

    @Override
    public void DeleteAssociation(UUID clientID, Integer homeID) {
        try {
            Optional<ClientHomeAssociation> association = GetAssociation(clientID, homeID);
            if (association.isPresent()) {
                repo.delete(association.get());
            } else {
                throw new RuntimeException("Association not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("DeleteAssociation: Error deleting association: " + e.getMessage());
        }
    }
}

