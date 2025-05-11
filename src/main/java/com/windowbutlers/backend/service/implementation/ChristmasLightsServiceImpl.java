package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.dto.ChristmasLightsRequest;
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

    public String createChristmasLights(ChristmasLightsRequest request) {
        
        ChristmasLights cl = new ChristmasLights();

        cl.setStorageLocation(request.getStorageLocation());
        cl.setInUse(request.getInUse());
        cl.setColor(LightColors.valueOf(request.getColor().toUpperCase()));

        clRepo.save(cl);

        return cl.getId().toString();
    }

    public String getChristmasLightsStorageLocation(UUID id) {
        
        return clRepo.findById(id).orElseThrow(() -> new DataNotFoundException("GetChristmasLightingStorageLocation: Christmas lighting ID not found in the database")).getStorageLocation();
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

    public void updateStorageLocation(UUID id, String storageLocation) {

        ChristmasLights cl = clRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateStorageLocation: Christmas lighting ID not found in the database"));
        cl.setStorageLocation(storageLocation);
        clRepo.save(cl);
    }

    public void updateInUse(UUID id, boolean inUse) {
        
        ChristmasLights cl = clRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateInUse: Christmas lighting ID not found in the database"));
        cl.setInUse(inUse);
        clRepo.save(cl);
    }

    public void deleteChristmasLights(UUID id) {

        if (!clRepo.existsById(id)) {
            throw new DataNotFoundException("DeleteChristmasLights: Christmas lighting ID not found in the database");
        }
        clRepo.deleteById(id);
    }
}
