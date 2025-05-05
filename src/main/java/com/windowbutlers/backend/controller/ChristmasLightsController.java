package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.ChristmasLights;
import com.windowbutlers.backend.service.ChristmasLightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/christmas-lighting")
public class ChristmasLightsController {

    @Autowired
    private ChristmasLightsService clService;

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createChristmasLights(@RequestBody ChristmasLights cl) {

        clService.createChristmasLights(cl);
        return ResponseEntity.status(HttpStatus.CREATED).body(cl);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allJobs/{id}")
    public ResponseEntity<?> GetAllChristmasLights() {

        List<ChristmasLights> cl = clService.getAllChristmasLights();
        return ResponseEntity.status(HttpStatus.OK).body(cl);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allByHome/{homeID}")
    public ResponseEntity<?> GetAllChristmasLightsByHomeID(@PathVariable Integer homeID) {

        List<ChristmasLights> cl = clService.getAllChristmasLightsByHomeID(homeID);
        return ResponseEntity.status(HttpStatus.OK).body(cl);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/storageLocation/{id}")
    public ResponseEntity<?> GetChristmasLightsStorageLocation(@PathVariable String ID) {

        String storageLocation = clService.getChristmasLightstorageLocation(ID);
        return ResponseEntity.status(HttpStatus.OK).body(storageLocation);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allInUse")
    public ResponseEntity<?> GetAllInUseChristmasLights() {

        List<ChristmasLights> cl = clService.getAllInUseChristmasLights();
        return ResponseEntity.status(HttpStatus.OK).body(cl);
    }

    // Passes Happy Path testing:
    @PutMapping("/update/storageLocation/{id}")
    public ResponseEntity<?> UpdateChristmasLightsStorageLocation(@PathVariable String ID, @RequestBody String storageLocation) {

        clService.updateChristmasLightsStorageLocation(ID, storageLocation);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Storage Location for %s to %s", ID, storageLocation));
    }

    // Passes Happy Path testing:
    @PutMapping("/update/inUse/{id}")
    public ResponseEntity<?> UpdateChristmasLightsInUse(@PathVariable String ID, @RequestBody Boolean inUse) {

        clService.updateChristmasLightsInUse(ID, inUse);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated In Use for %s to %s", ID, inUse));
    }

    // Passes Happy Path testing:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteChristmasLights(@PathVariable String ID) {

        clService.deleteChristmasLights(ID);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Christmas Lights %s deleted successfully", ID));
    }
}
