package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Integer> {

    // Retrieve a ClientID by the composite key
    @Query("SELECT c.id FROM Client c WHERE c.first_name = :firstName AND c.last_name = :lastName AND (:email IS NULL OR c.email = :email) AND (:phoneNumber IS NULL OR c.phone_number = :phoneNumber)")
    Optional<Integer> findByFirstNameAndLastNameAndOptionalEmailAndPhoneNumber(
        @Param("firstName") String firstName,
        @Param("lastName") String lastName,
        @Param("email") String email,
        @Param("phoneNumber") String phoneNumber
    );
}
    

