package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ChristmasLighting;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public interface ChristmasLightingService {
    
    ChristmasLighting CreateChristmasLighting(ChristmasLighting cl);

    String GetChristmasLightingStorageLocation(UUID id);

    List<ChristmasLighting> GetAllChristmasLightings();

    Optional<List<ChristmasLighting>> GetAllInUseChristmasLightings();

    List<ChristmasLighting> GetAllChristmasLightingsByHomeID(Integer home_id);

    ChristmasLighting UpdateStorageLocation(ChristmasLighting cl, String storage_location);

    ChristmasLighting UpdateInUse(ChristmasLighting cl, boolean in_use);

    void DeleteChristmasLighting(UUID id);    
}
