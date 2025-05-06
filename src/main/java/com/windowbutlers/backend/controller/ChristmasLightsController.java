package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.service.ChristmasLightsService;
import com.windowbutlers.backend.dto.ChristmasLightsRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/christmas-lighting")
public class ChristmasLightsController {

    private final ChristmasLightsService clService;

    public ChristmasLightsController(ChristmasLightsService clService) {
        this.clService = clService;
    }

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createChristmasLights(@RequestBody ChristmasLightsRequest cl) {

        String id = clService.createChristmasLights(cl);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created a new Christmas light (%s)".formatted(id));
    }

    // Passes Happy Path testing:
    @GetMapping("/get/storageLocation/{id}")
    public ResponseEntity<?> getChristmasLightsStorageLocation(@PathVariable String ID) {

        String storageLocation = clService.getChristmasLightsStorageLocation(ID);
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
    public ResponseEntity<?> getAllChristmasLightsByHomeID(@PathVariable Integer homeID) {

        List<ChristmasLights> cl = clService.getAllChristmasLightsByHomeID(homeID);
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
    public ResponseEntity<?> updateChristmasLightsStorageLocation(@PathVariable String ID, @RequestBody String storageLocation) {

        clService.updateStorageLocation(ID, storageLocation);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Storage Location for %s to %s", ID, storageLocation));
    }

    // Passes Happy Path testing:
    @PutMapping("/update/inUse/{id}")
    public ResponseEntity<?> updateChristmasLightsInUse(@PathVariable String ID, @RequestBody Boolean inUse) {

        clService.updateInUse(ID, inUse);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated In Use for %s to %s", ID, inUse));
    }

    // Passes Happy Path testing:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChristmasLights(@PathVariable String ID) {

        clService.deleteChristmasLights(ID);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Christmas Lights %s deleted successfully", ID));
    }
}
