package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Clients;
import com.windowbutlers.backend.dto.ClientRequest;
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

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody ClientRequest client) {

        String id = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Sucessfully created a new client (%s)", id));
    }

    // Passes Happy Path testing:
    @GetMapping("/get/singleClient/{id}")
    public ResponseEntity<?> getSingleClient(@PathVariable String id) {

        Clients client = clientService.getClient(id);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allClients")
    public ResponseEntity<?> getAllClients() {

        List<Clients> clients = clientService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    // Passes Happy Path testing:
    @PutMapping("/update/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable String id, @RequestBody String email) {

        clientService.updateEmail(id, email);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Email for %s to %s", id, email));
    }

    // Passes Happy Path testing:
    @PutMapping("/update/phoneNumber/")
    public ResponseEntity<?> updatePhoneNumber(@PathVariable String id, @RequestBody String phoneNumber) {

        clientService.updatePhoneNumber(id, phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Phone Number for %s to %s", id, phoneNumber));
    }

    // Passes Happy Path testing:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable String id) {

        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted Client with ID %s", id));
    }
}
