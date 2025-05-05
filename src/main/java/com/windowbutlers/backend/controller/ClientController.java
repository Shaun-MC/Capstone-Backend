package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Client;
import com.windowbutlers.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody Client client) {

        clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    // Passes Happy Path testing: 
    @GetMapping("/get/singleClient/{id}")
    public ResponseEntity<?> getSingleClient(@PathVariable String ID) {

        Client client = clientService.getClient(ID);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allClients")
    public ResponseEntity<?> getAllClients() {

        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    // Passes Happy Path testing:
    @PutMapping("/update/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable String ID, @RequestBody String email) {

        clientService.updateEmail(ID, email);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Email for %s to %s", ID, email));
    }

    // Passes Happy Path testing:
    @PutMapping("/update/phoneNumber/")
    public ResponseEntity<?> updatePhoneNumber(@PathVariable String ID, @RequestBody String phoneNumber) {

        clientService.updatePhoneNumber(ID, phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Phone Number for %s to %s", ID, phoneNumber));
    }

    // Passes Happy Path testing:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable String ID) {

        clientService.deleteClient(ID);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted Client with ID %s", ID));
    }
}
