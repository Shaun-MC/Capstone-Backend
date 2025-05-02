package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.entity.ClientHomeKey;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface ClientHomeAssociationRepo extends JpaRepository<ClientHomeAssociation, ClientHomeKey> {

    List<ClientHomeAssociation> findByClientId(UUID clientId);
    
    List<ClientHomeAssociation> findByHomeId(Integer homeId);
    
    Optional<ClientHomeAssociation> findByClientIdAndHomeId(UUID clientId, Integer homeId);
}
