package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.ChristmasLights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.List;

@Repository
public interface ChristmasLightsRepo extends JpaRepository<ChristmasLights, UUID> {

    // Custom query to find all Christmas lightings that are in use
    @Query("SELECT cl FROM ChristmasLighting cl WHERE cl.in_use = true")
    List<ChristmasLights> findByInUse();

    // Custom query to find all Christmas lightings by home ID
    @Query("SELECT cl FROM ChristmasLighting cl JOIN cl.job j JOIN j.home h WHERE h.id = :homeId")
    List<ChristmasLights> findByHomeId(@Param("home_id") Integer home_id);
}
