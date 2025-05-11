package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.dto.BooleanUpdateRequest;
import com.windowbutlers.backend.dto.ChristmasLightsRequest;
import com.windowbutlers.backend.dto.StorageLocationUpdateRequest;
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

    String updateStorageLocation(UUID id, StorageLocationUpdateRequest req);

    boolean updateInUse(UUID id, BooleanUpdateRequest req);

    void deleteChristmasLights(UUID id);    
}
