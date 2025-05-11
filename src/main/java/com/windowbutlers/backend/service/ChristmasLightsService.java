package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.dto.ChristmasLightsRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ChristmasLightsService {
    
    String createChristmasLights(ChristmasLightsRequest cl);

    String getChristmasLightsStorageLocation(UUID id);

    List<ChristmasLights> getAllChristmasLightsByHomeID(UUID homeID);

    List<ChristmasLights> getAllChristmasLights();

    List<ChristmasLights> getAllInUseChristmasLights();

    void updateStorageLocation(UUID id, String storageLocation);

    void updateInUse(UUID id, boolean inUse);

    void deleteChristmasLights(UUID id);    
}
