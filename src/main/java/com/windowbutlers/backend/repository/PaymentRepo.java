package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, UUID> {
    
    @Query("SELECT p FROM Payment p WHERE p.client.id = :clientId")
    List<Payment> findByClientId(@Param("clientId") UUID clientId);
}


