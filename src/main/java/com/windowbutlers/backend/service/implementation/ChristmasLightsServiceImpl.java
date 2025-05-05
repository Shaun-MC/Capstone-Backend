package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.service.ChristmasLightsService;
import com.windowbutlers.backend.repository.ChristmasLightingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Component
public class ChristmasLightsServiceImpl implements ChristmasLightsService {

    @Autowired
    private ChristmasLightingRepo clRepo;

    public ChristmasLights CreateChristmasLighting(ChristmasLights cl) {

        try {
            return clRepo.save(cl);
        } catch (Exception e) {
            throw new RuntimeException("CreateChristmasLighting: Error creating Christmas lighting: " + e.getMessage());
        }
    }

    public String GetChristmasLightingStorageLocation(UUID id) {
        
        try {
            ChristmasLights cl = clRepo.findById(id).orElseThrow(() -> new RuntimeException("GetChristmasLightingStorageLocation: Christmas lighting not found in the database"));
            return cl.getStorageLocation();
        } catch (Exception e) {
            throw new RuntimeException("GetChristmasLightingStorageLocation: Error retrieving storage location: " + e.getMessage());
        }
    }

    public List<ChristmasLights> GetAllChristmasLightings() {

        try {
            return clRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("GetAllChristmasLightings: Error retrieving all Christmas lightings: " + e.getMessage());
        }
    }

    public List<ChristmasLights> GetAllChristmasLightingsByHomeID(Integer home_id) {
        try {
            return clRepo.findByHomeId(home_id);
        } catch (Exception e) {
            throw new RuntimeException("GetAllInUseChristmasLightings: Error retrieving in-use Christmas lightings: " + e.getMessage());
        }
    }

    public Optional<List<ChristmasLights>> GetAllInUseChristmasLightings() {
        
        try {
            return clRepo.findByInUse();
        } catch (Exception e) {
            throw new RuntimeException("GetAllInUseChristmasLightings: Error retrieving in-use Christmas lightings: " + e.getMessage());
        }
    }

    public ChristmasLights UpdateStorageLocation(ChristmasLights cl, String storage_location) {

        try {
            cl.setStorageLocation(storage_location);
            return clRepo.save(cl);
        } catch (Exception e) {
            throw new RuntimeException("UpdateStorageLocation: Error updating storage location: " + e.getMessage());
        }
    }

    public ChristmasLights UpdateInUse(ChristmasLights cl, boolean in_use) {
        try {
            cl.setInUse(in_use);
            return clRepo.save(cl);
        } catch (Exception e) {
            throw new RuntimeException("UpdateInUse: Error updating in use status: " + e.getMessage());
        }
    }

    public void DeleteChristmasLighting(UUID id) {

        try {
            clRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("DeleteChristmasLighting: Error deleting Christmas lighting: " + e.getMessage());
        }
    }
}
