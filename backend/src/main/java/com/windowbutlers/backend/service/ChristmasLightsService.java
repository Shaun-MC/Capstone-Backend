package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.dto.requests.BooleanUpdateRequest;
import com.windowbutlers.backend.dto.requests.ChristmasLightsRequest;
import com.windowbutlers.backend.dto.requests.StorageLocationUpdateRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.LocationResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ChristmasLightsService {
    
    IDResponse createChristmasLights(ChristmasLightsRequest cl);

    LocationResponse getChristmasLightsStorageLocation(UUID id);

    List<ChristmasLights> getAllChristmasLightsByHomeID(UUID homeID);

    List<ChristmasLights> getAllChristmasLights();

    List<ChristmasLights> getAllInUseChristmasLights();

    SuccessfulUpdateResponse updateStorageLocation(UUID id, StorageLocationUpdateRequest req);

    SuccessfulUpdateResponse updateInUse(UUID id, BooleanUpdateRequest req);

    DeleteMessageResponse deleteChristmasLights(UUID id);    
}
