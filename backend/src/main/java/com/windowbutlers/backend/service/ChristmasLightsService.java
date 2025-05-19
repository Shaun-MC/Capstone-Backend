package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.dto.BooleanUpdateRequest;
import com.windowbutlers.backend.dto.BooleanResponce;
import com.windowbutlers.backend.dto.ChristmasLightsRequest;
import com.windowbutlers.backend.dto.DeleteMessageResponce;
import com.windowbutlers.backend.dto.StorageLocationUpdateRequest;
import com.windowbutlers.backend.dto.IDResponce;
import com.windowbutlers.backend.dto.LocationResponce;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ChristmasLightsService {
    
    IDResponce createChristmasLights(ChristmasLightsRequest cl);

    LocationResponce getChristmasLightsStorageLocation(UUID id);

    List<ChristmasLights> getAllChristmasLightsByHomeID(UUID homeID);

    List<ChristmasLights> getAllChristmasLights();

    List<ChristmasLights> getAllInUseChristmasLights();

    LocationResponce updateStorageLocation(UUID id, StorageLocationUpdateRequest req);

    BooleanResponce updateInUse(UUID id, BooleanUpdateRequest req);

    DeleteMessageResponce deleteChristmasLights(UUID id);    
}
