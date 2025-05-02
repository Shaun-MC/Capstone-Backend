package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

@Repository
public interface HomeRepo extends JpaRepository<Home, Integer>{

    @Query("SELECT h.id FROM Home h WHERE h.address_line_1 = :address_line_1 AND h.city = :city AND h.zip_code = :zip_code")
    Optional<Integer> findByAddressLine1AndCityAndZipCode(
        @Param("address_line_1") String address_line_1,
        @Param("city") String city,
        @Param("zip_code") String zip_code
    );
}
