package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.dto.BooleanResponce;
import com.windowbutlers.backend.dto.BooleanUpdateRequest;
import com.windowbutlers.backend.dto.ChristmasLightsRequest;
import com.windowbutlers.backend.dto.DeleteMessageResponce;
import com.windowbutlers.backend.dto.StorageLocationUpdateRequest;
import com.windowbutlers.backend.dto.IDResponce;
import com.windowbutlers.backend.dto.LocationResponce;
import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.service.ChristmasLightsService;
import com.windowbutlers.backend.repository.ChristmasLightsRepo;
import com.windowbutlers.backend.enums.LightColors;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class ChristmasLightsServiceImpl implements ChristmasLightsService {

    private final ChristmasLightsRepo clRepo;

    public ChristmasLightsServiceImpl(ChristmasLightsRepo clRepo) {
        this.clRepo = clRepo;
    }

    public IDResponce createChristmasLights(ChristmasLightsRequest request) {
        
        ChristmasLights cl = new ChristmasLights();

        cl.setStorageLocation(request.getStorageLocation());
        cl.setInUse(request.getInUse());
        cl.setColor(LightColors.valueOf(request.getColor().toUpperCase()));

        clRepo.save(cl);

        return new IDResponce(cl.getId()); 
    }

    public LocationResponce getChristmasLightsStorageLocation(UUID id) {
        
        return new LocationResponce(id, clRepo.findById(id).orElseThrow(() -> new DataNotFoundException("GetChristmasLightingStorageLocation: Christmas lighting ID not found in the database")).getStorageLocation());
    }

    public List<ChristmasLights> getAllChristmasLightsByHomeID(UUID homeID) {
        
        return clRepo.findByHome_Id(homeID);
    }

    public List<ChristmasLights> getAllChristmasLights() {

        return clRepo.findAll();
    }

    public List<ChristmasLights> getAllInUseChristmasLights() {
        
        return clRepo.findByInUse();
    }

    public LocationResponce updateStorageLocation(UUID id, StorageLocationUpdateRequest req) {
        
        ChristmasLights cl = clRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateStorageLocation: Christmas lighting ID not found in the database"));
        String storageLocation = req.getStorageLocation();
        
        cl.setStorageLocation(storageLocation);
        clRepo.save(cl);

        return new LocationResponce(id, cl.getStorageLocation());
    }

    public BooleanResponce updateInUse(UUID id, BooleanUpdateRequest req) {
        
        Boolean inUse = req.getValue();
        ChristmasLights cl = clRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateInUse: Christmas lighting ID not found in the database"));
        
        cl.setInUse(inUse);
        clRepo.save(cl);

        return new BooleanResponce(id, cl.getInUse());
    }

    public DeleteMessageResponce deleteChristmasLights(UUID id) {

        if (!clRepo.existsById(id)) {
            throw new DataNotFoundException("DeleteChristmasLights: Christmas lighting ID not found in the database");
        }
        clRepo.deleteById(id);
        
        return new DeleteMessageResponce("Christmas Lights");
    }
}
