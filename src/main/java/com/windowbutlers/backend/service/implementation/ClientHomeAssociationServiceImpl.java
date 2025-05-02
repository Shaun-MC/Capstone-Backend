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
    public List<ClientHomeAssociation> GetHomesForClient(UUID clientId) {
        try {
            return repo.findByClientId(clientId);
        } catch (Exception e) {
            throw new RuntimeException("GetHomesForClient: Error retrieving homes for client: " + e.getMessage());
        }
    }

    @Override
    public List<ClientHomeAssociation> GetClientsForHome(Integer homeId) {
        try {
            return repo.findByHomeId(homeId);
        } catch (Exception e) {
            throw new RuntimeException("GetClientsForHome: Error retrieving clients for home: " + e.getMessage());
        }
    }

    @Override
    public Optional<ClientHomeAssociation> GetAssociation(UUID clientId, Integer homeId) {
        try {
            return repo.findByClientIdAndHomeId(clientId, homeId);
        } catch (Exception e) {
            throw new RuntimeException("GetAssociation: Error retrieving association: " + e.getMessage());
        }
    }

    @Override
    public void DeleteAssociation(UUID clientId, Integer homeId) {
        try {
            Optional<ClientHomeAssociation> association = GetAssociation(clientId, homeId);
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

