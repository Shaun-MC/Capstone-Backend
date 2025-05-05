package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ClientHomeAssociation;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ClientHomeAssociationService {

    ClientHomeAssociation SaveAssociation(ClientHomeAssociation association);

    List<ClientHomeAssociation> GetHomesForClient(UUID clientID);

    List<ClientHomeAssociation> GetClientsForHome(Integer homeID);

    Optional<ClientHomeAssociation> GetAssociation(UUID clientID, Integer homeID);

    void DeleteAssociation(UUID clientID, Integer homeID);
}