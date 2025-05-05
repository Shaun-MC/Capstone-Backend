package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ChristmasLights;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public interface ChristmasLightsService {
    
    ChristmasLights CreateChristmasLighting(ChristmasLights cl);

    String GetChristmasLightingStorageLocation(UUID id);

    List<ChristmasLights> GetAllChristmasLightings();

    Optional<List<ChristmasLights>> GetAllInUseChristmasLightings();

    List<ChristmasLights> GetAllChristmasLightingsByHomeID(Integer homeID);

    ChristmasLights UpdateStorageLocation(ChristmasLights cl, String storageLocation);

    ChristmasLights UpdateInUse(ChristmasLights cl, boolean inUse);

    void DeleteChristmasLighting(UUID id);    
}
