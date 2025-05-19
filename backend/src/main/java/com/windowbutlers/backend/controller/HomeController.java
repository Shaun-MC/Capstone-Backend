package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.service.HomeService;
import com.windowbutlers.backend.validation.ValidUUID;
import com.windowbutlers.backend.dto.requests.HomeRequest;
import com.windowbutlers.backend.dto.requests.NotesUpdateRequest;
import com.windowbutlers.backend.dto.requests.PowerSourceLocationUpdateRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    // Passes Happy Path testing: 5/10/25
    @PostMapping("/create")
    public ResponseEntity<?> createHome(@RequestBody @Valid HomeRequest home) {
        
        IDResponse response = homeService.createHome(home);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/singleHome/{id}")
    public ResponseEntity<?> getSingleHome(@PathVariable @ValidUUID String id) {

        Homes home = homeService.getHome(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(home);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/allHomes")
    public ResponseEntity<?> getAllHomes() {
        
        List<Homes> homes = homeService.getAllHomes();
        return ResponseEntity.status(HttpStatus.OK).body(homes);
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("/update/notes/{id}")
    public ResponseEntity<?> updateNotes(@PathVariable @ValidUUID String id, @RequestBody @Valid NotesUpdateRequest req) {
        
        SuccessfulUpdateResponse response = homeService.updateNotes(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("/update/powerSourceLocation/{id}")
    public ResponseEntity<?> updatePowerSourceLocation(@PathVariable @ValidUUID String id, @RequestBody @Valid PowerSourceLocationUpdateRequest req) {
        
        SuccessfulUpdateResponse response = homeService.updatePowerSourceLocation(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Passes Happy Path testing: 5/11/25
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHome(@PathVariable @ValidUUID String id) {

        DeleteMessageResponse response = homeService.deleteHome(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
