package com.windowbutlers.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.windowbutlers.backend.entity.Client;
import com.windowbutlers.backend.service.ClientService;
import java.util.List;

// TODO:
// 1. Add logging to the controller
// 2. Make an input validation function
// 3. Make the error messages more descriptive

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Passes Happy Path testing - 5 / 1 / 2025
    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody Client client) {

        try {
            clientService.CreateClient(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Passes Happy Path testing - 5 / 1 / 2025
    @GetMapping("/getSingleClient/")
    public ResponseEntity<?> getSingleClient(@RequestParam String first_name, @RequestParam String last_name, @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone_number) {

        // Input validation
        if ((first_name == null || first_name.isBlank()) || (last_name == null || last_name.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'first_name' and 'last_name' cannot be null or blank.");
        }

        if ((email == null || email.isBlank()) && (phone_number == null || phone_number.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("At least one of 'email' or 'phone_number' must be provided.");
        }

        // Retrieve the client using the service
        try {
            Client client = clientService.GetClient(first_name, last_name, email, phone_number);
            return ResponseEntity.status(HttpStatus.OK).body(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Passes Happy Path testing - 5 / 1 / 2025
    @GetMapping("/getAllClients")
    public ResponseEntity<?> getAllClients() {

        try {
            List<Client> clients = clientService.GetAllClients();
            return ResponseEntity.status(HttpStatus.OK).body(clients);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Passes Happy Path testing - 5 / 1 / 2025
    @PutMapping("/update/")
    public ResponseEntity<?> updateClient(@RequestBody Client client, @RequestParam String first_name, @RequestParam String last_name, @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone_number) {

        // Body validation - make more robust, check individual fields exist, fine for now
        if (client == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("JSON object cannot be null.");
        }

        if ((first_name == null || first_name.isBlank()) || (last_name == null || last_name.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'first_name' and 'last_name' cannot be null or blank.");
        }

        if ((email == null || email.isBlank()) && (phone_number == null || phone_number.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("At least one of 'email' or 'phone_number' must be provided.");
        }

        try {
            Client updated_client = clientService.UpdateClient(client, first_name, last_name, email, phone_number);
            return ResponseEntity.status(HttpStatus.OK).body(updated_client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Passes Happy Path testing - 5 / 1 / 2025
    @DeleteMapping("/delete/")
    public ResponseEntity<String> deleteClient(@RequestParam String first_name, @RequestParam String last_name, @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone_number) {

        if ((first_name == null || first_name.isBlank()) || (last_name == null || last_name.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'first_name' and 'last_name' cannot be null or blank.");
        }
        if ((email == null || email.isBlank()) && (phone_number == null || phone_number.isBlank())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("At least one of 'email' or 'phone_number' must be provided.");
        }

        try {
            clientService.DeleteClient(first_name, last_name, email, phone_number);
            return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting client");
        }
    }
}
