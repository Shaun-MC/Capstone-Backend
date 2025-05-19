package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.service.ChristmasLightsService;
import com.windowbutlers.backend.dto.ChristmasLightsRequest;
import com.windowbutlers.backend.dto.DeleteMessageResponce;
import com.windowbutlers.backend.dto.StorageLocationUpdateRequest;
import com.windowbutlers.backend.dto.BooleanResponce;
import com.windowbutlers.backend.dto.BooleanUpdateRequest;
import com.windowbutlers.backend.dto.IDResponce;
import com.windowbutlers.backend.dto.LocationResponce;
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

    // Passes Happy Path testing: 5/11/2025
    @PostMapping("/create")
    public ResponseEntity<?> createChristmasLights(@RequestBody @Valid ChristmasLightsRequest cl) {

        IDResponce id = clService.createChristmasLights(cl);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    // Passes Happy Path testing: 5/11/2025
    @GetMapping("/get/storageLocation/{id}")
    public ResponseEntity<?> getChristmasLightsStorageLocation(@PathVariable @ValidUUID String id) {

        LocationResponce storageLocation = clService.getChristmasLightsStorageLocation(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(storageLocation);
    }

    // Passes Happy Path testing: 5/11/2025
    @GetMapping("/get/allChristmasLights")
    public ResponseEntity<?> getAllChristmasLights() {

        List<ChristmasLights> cls = clService.getAllChristmasLights();
        return ResponseEntity.status(HttpStatus.OK).body(cls);
    }

    // Passes Happy Path testing: 5/11/2025
    @GetMapping("/get/allChristmasLightsByHome/{homeID}")
    public ResponseEntity<?> getAllChristmasLightsByHomeID(@PathVariable @ValidUUID String homeID) {

        List<ChristmasLights> cl = clService.getAllChristmasLightsByHomeID(UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body(cl);
    }

    // Passes Happy Path testing: 5/11/2025 5/11/2025
    @GetMapping("/get/allInUse")
    public ResponseEntity<?> getAllInUseChristmasLights() {

        List<ChristmasLights> cl = clService.getAllInUseChristmasLights();
        return ResponseEntity.status(HttpStatus.OK).body(cl);
    }

    // Passes Happy Path testing: 5/11/2025 5/11/2025
    @PutMapping("/update/storageLocation/{id}")
    public ResponseEntity<?> updateChristmasLightsStorageLocation(@PathVariable @ValidUUID String id, @RequestBody @Valid StorageLocationUpdateRequest storageLocation) {

        LocationResponce location = clService.updateStorageLocation(UUID.fromString(id), storageLocation);
        return ResponseEntity.status(HttpStatus.OK).body(location);
    }

    // Passes Happy Path testing: 5/11/2025
    @PutMapping("/update/inUse/{id}")
    public ResponseEntity<?> updateChristmasLightsInUse(@PathVariable @ValidUUID String id, @RequestBody @Valid BooleanUpdateRequest req) {

        BooleanResponce responce = clService.updateInUse(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(responce);
    }

    // Passes Happy Path testing: 5/11/2025
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChristmasLights(@PathVariable @ValidUUID String id) {

        DeleteMessageResponce responce = clService.deleteChristmasLights(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(responce);
    }
}
