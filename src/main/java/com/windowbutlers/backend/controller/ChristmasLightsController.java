package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.service.ChristmasLightsService;
import com.windowbutlers.backend.dto.ChristmasLightsRequest;
import com.windowbutlers.backend.dto.StorageLocationUpdateRequest;
import com.windowbutlers.backend.dto.BooleanUpdateRequest;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/christmas-lights")
public class ChristmasLightsController {

    private final ChristmasLightsService clService;

    public ChristmasLightsController(ChristmasLightsService clService) {
        this.clService = clService;
    }

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createChristmasLights(@RequestBody @Valid ChristmasLightsRequest cl) {

        String id = clService.createChristmasLights(cl);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Successfully created a new Christmas light (%s)", id));
    }

    // Passes Happy Path testing:
    @GetMapping("/get/storageLocation/{id}")
    public ResponseEntity<?> getChristmasLightsStorageLocation(@PathVariable @ValidUUID String id) {

        String storageLocation = clService.getChristmasLightsStorageLocation(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(storageLocation);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allChristmasLights")
    public ResponseEntity<?> getAllChristmasLights() {

        List<ChristmasLights> cls = clService.getAllChristmasLights();
        return ResponseEntity.status(HttpStatus.OK).body(cls);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allChristmasLightsByHome/{homeID}")
    public ResponseEntity<?> getAllChristmasLightsByHomeID(@PathVariable @ValidUUID String homeID) {

        List<ChristmasLights> cl = clService.getAllChristmasLightsByHomeID(UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body(cl);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allInUse")
    public ResponseEntity<?> getAllInUseChristmasLights() {

        List<ChristmasLights> cl = clService.getAllInUseChristmasLights();
        return ResponseEntity.status(HttpStatus.OK).body(cl);
    }

    // Passes Happy Path testing:
    @PutMapping("/update/storageLocation/{id}")
    public ResponseEntity<?> updateChristmasLightsStorageLocation(@PathVariable @ValidUUID String id, @RequestBody @Valid StorageLocationUpdateRequest storageLocation) {

        String location = clService.updateStorageLocation(UUID.fromString(id), storageLocation);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Storage Location for %s to %s", id, location));
    }

    // Passes Happy Path testing:
    @PutMapping("/update/inUse/{id}")
    public ResponseEntity<?> updateChristmasLightsInUse(@PathVariable @ValidUUID String id, @RequestBody @Valid BooleanUpdateRequest req) {

        boolean useStatus = clService.updateInUse(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated In Use for %s to %s", id, useStatus));
    }

    // Passes Happy Path testing:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChristmasLights(@PathVariable @ValidUUID String id) {

        clService.deleteChristmasLights(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Christmas Lights %s deleted successfully", id));
    }
}
