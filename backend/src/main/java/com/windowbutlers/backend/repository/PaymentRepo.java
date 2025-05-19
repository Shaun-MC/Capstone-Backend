package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepo extends JpaRepository<Payments, UUID> {
    
    @Query("SELECT p FROM Payments p WHERE p.client.id = :clientID")
    List<Payments> findByClientID(@Param("clientID") UUID clientID);
}


