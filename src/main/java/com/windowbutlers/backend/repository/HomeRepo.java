package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

@Repository
public interface HomeRepo extends JpaRepository<Home, Integer>{

    @Query("SELECT h.id FROM Home h WHERE h.addressLine1 = :addressLine1 AND h.city = :city AND h.zipCode = :zipCode")
    Optional<Integer> findByAddressLine1AndCityAndZipCode(
        @Param("addressLine1") String addressLine1,
        @Param("city") String city,
        @Param("zipCode") String zipCode
    );
}
