package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.dto.ChristmasLightsRequest;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface ChristmasLightsService {
    
    String createChristmasLights(@Valid ChristmasLightsRequest cl);

    String getChristmasLightsStorageLocation(@ValidUUID String ID);

    List<ChristmasLights> getAllChristmasLightsByHomeID(@ValidUUID String homeID);

    List<ChristmasLights> getAllChristmasLights();

    List<ChristmasLights> getAllInUseChristmasLights();

    void updateStorageLocation(@ValidUUID String ID, String storageLocation);

    void updateInUse(@ValidUUID String ID, boolean inUse);

    void deleteChristmasLights(@ValidUUID String id);    
}
