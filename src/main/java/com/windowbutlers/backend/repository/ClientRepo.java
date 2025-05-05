package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepo extends JpaRepository<Client, UUID> {

    // Retrieve a ClientID by the composite key
    // Only accepts if the phone_number or email is also correct - TODO
    @Query("SELECT c.id FROM Client c WHERE c.firstName = :firstName AND c.lastName = :lastName AND (:email IS NULL OR c.email = :email) AND (:phoneNumber IS NULL OR c.phoneNumber = :phoneNumber)")
    Optional<UUID> findByFirstNameAndLastNameAndOptionalEmailAndPhoneNumber(
        @Param("firstName") String firstName,
        @Param("lastName") String lastName,
        @Param("email") String email,
        @Param("phoneNumber") String phoneNumber
    );
}