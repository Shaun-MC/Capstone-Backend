package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ClientHomeAssociation;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ClientHomeAssociationService {

    ClientHomeAssociation SaveAssociation(ClientHomeAssociation association);

    List<ClientHomeAssociation> GetHomesForClient(UUID clientId);

    List<ClientHomeAssociation> GetClientsForHome(Integer homeId);

    Optional<ClientHomeAssociation> GetAssociation(UUID clientId, Integer homeId);

    void DeleteAssociation(UUID clientId, Integer homeId);
}