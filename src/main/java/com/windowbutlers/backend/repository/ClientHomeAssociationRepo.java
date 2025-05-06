package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.entity.ClientHomeKey;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.UUID;
import java.util.List;

@Repository
public interface ClientHomeAssociationRepo extends JpaRepository<ClientHomeAssociation, ClientHomeKey> {

    List<ClientHomeAssociation> findByClientID(UUID clientID);
    
    List<ClientHomeAssociation> findByHomeID(Integer homeID);
    
    String findByClientIDAndHomeID(UUID clientID, Integer homeID);

    @Query("SELECT cha.relation FROM ClientHomeAssociation cha WHERE cha.homeID = :homeID")
    List<String> findAssociationsByHomeID(Integer homeID);
}
