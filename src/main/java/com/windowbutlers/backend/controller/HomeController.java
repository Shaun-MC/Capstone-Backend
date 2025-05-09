package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.service.HomeService;
import com.windowbutlers.backend.dto.HomeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createHome(@RequestBody HomeRequest home) {
        
        String ID = homeService.createHome(home);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Successfully created a new home (%d)", ID));
    }

    // Passes Happy Path testing:
    @GetMapping("/get/singleHome/{id}")
    public ResponseEntity<?> getSingleHome(@PathVariable String id) {

        Homes home = homeService.getHome(id);
        return ResponseEntity.status(HttpStatus.OK).body(home);
    }

    // Passes Happy Path testing
    @GetMapping("/get/allHomes")
    public ResponseEntity<?> getAllHomes() {
        
        List<Homes> homes = homeService.getAllHomes();
        return ResponseEntity.status(HttpStatus.OK).body(homes);
    }

    // Passes Happy Path testing
    @PutMapping("/update/powerSourceLocation/{id}")
    public ResponseEntity<?> updatePowerSourceLocation(@PathVariable String id, @RequestBody String powerSourceLocation) {
        
        homeService.updatePowerSourceLocation(id, powerSourceLocation);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Power Source Location for %s to %s", id, powerSourceLocation));
    }

    // Passes Happy Path testing
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHome(@PathVariable String id) {

        homeService.deleteHome(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted Home with ID: %s", id));
    }
}
