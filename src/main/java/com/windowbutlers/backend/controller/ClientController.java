package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Clients;
import com.windowbutlers.backend.dto.ClientRequest;
import com.windowbutlers.backend.dto.EmailUpdateRequest;
import com.windowbutlers.backend.dto.PhoneNumberUpdateRequest;
import com.windowbutlers.backend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Passes Happy Path testing: 5/10/25
    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody ClientRequest client) {

        String id = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Sucessfully created a new client (%s)", id));
    }

    // Passes Happy Path testing: 5/10/25
    @GetMapping("/get/singleClient/{id}")
    public ResponseEntity<?> getSingleClient(@PathVariable String id) {

        Clients client = clientService.getClient(id);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    // Passes Happy Path testing: 5/10/25
    @GetMapping("/get/allClients")
    public ResponseEntity<?> getAllClients() {

        List<Clients> clients = clientService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    // Passes Happy Path testing: 5/10/25
    @PutMapping("/update/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable String id, @RequestBody EmailUpdateRequest req) {

        String validEmail = clientService.updateEmail(id, req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Email for %s to %s", id, validEmail));
    }

    // Passes Happy Path testing: 5/10/25
    @PutMapping("/update/phoneNumber/{id}")
    public ResponseEntity<?> updatePhoneNumber(@PathVariable String id, @RequestBody PhoneNumberUpdateRequest req) {

        String validNumber = clientService.updatePhoneNumber(id, req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Phone Number for %s to %s", id, validNumber));
    }

    // Passes Happy Path testing: 5/10/25
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable String id) {

        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted Client with ID %s", id));
    }
}
