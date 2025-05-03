package com.windowbutlers.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.windowbutlers.backend.entity.Home;
import com.windowbutlers.backend.service.HomeService;
import java.util.List;

// TODO:
// 1. Add logging to the controller
// 2. Make an input validation function
// 3. Make the error messages more descriptive

@RestController
@RequestMapping("/api/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    // Passes Happy Path testing - 5 / 1 / 2025
    @PostMapping("/create")
    public ResponseEntity<?> createHome(@RequestBody Home home) {
        try {
            homeService.CreateHome(home);
            return ResponseEntity.status(HttpStatus.CREATED).body(home);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Passes Happy Path testing - 5 / 1 / 2025
    @GetMapping("/getSingleHome/")
    public ResponseEntity<?> getSingleHome(@RequestParam String address_line_1, @RequestParam String city, @RequestParam String zip_code) {
        if ((address_line_1 == null || address_line_1.isBlank()) || (city == null || city.isBlank()) || (zip_code == null || zip_code.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parameters 'address_line_1', 'city', and 'zip_code' cannot be null or blank.");
        }
        try {
            Home home = homeService.GetHome(address_line_1, city, zip_code);
            return ResponseEntity.status(HttpStatus.OK).body(home);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Passes Happy Path testing - 5 / 1 / 2025
    @GetMapping("/getAllHomes")
    public ResponseEntity<?> getAllHomes() {
        try {
            List<Home> homes = homeService.GetAllHomes();
            return ResponseEntity.status(HttpStatus.OK).body(homes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Passes Happy Path testing - 5 / 1 / 2025
    @PutMapping("/update/")
    public ResponseEntity<?> updateHome(@RequestBody Home home, @RequestParam String address_line_1, @RequestParam String city, @RequestParam String zip_code) {
        if (home == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Home object cannot be null.");
        }
        if ((address_line_1 == null || address_line_1.isBlank()) || (city == null || city.isBlank()) || (zip_code == null || zip_code.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parameters 'address_line_1', 'city', and 'zip_code' cannot be null or blank.");
        }
        try {
            Home updatedHome = homeService.UpdateHome(home, address_line_1, city, zip_code);
            return ResponseEntity.status(HttpStatus.OK).body(updatedHome);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Passes Happy Path testing - 5 / 1 / 2025
    @DeleteMapping("/delete/")
    public ResponseEntity<String> deleteHome(@RequestParam String address_line_1, @RequestParam String city, @RequestParam String zip_code) {

        if ((address_line_1 == null || address_line_1.isBlank()) || (city == null || city.isBlank()) || (zip_code == null || zip_code.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parameters 'address_line_1', 'city', and 'zip_code' cannot be null or blank.");
        }

        try {
            homeService.DeleteHome(address_line_1, city, zip_code);
            return ResponseEntity.status(HttpStatus.OK).body("Home deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleteing home");
        }
    }
}
