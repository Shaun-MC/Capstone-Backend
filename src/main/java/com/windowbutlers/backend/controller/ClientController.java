package com.windowbutlers.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.windowbutlers.backend.entity.Client;
import com.windowbutlers.backend.service.ClientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {

        try {
            clientService.CreateClient(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getSingleClient/{first_name}/{last_name}/{email}/{phone_number}")
    public ResponseEntity<Client> getSingleClient(@PathVariable String first_name, @PathVariable String last_name,
            @PathVariable String email, @PathVariable String phone_number) {

        try {
            Client client = clientService.GetClient(first_name, last_name, email, phone_number);
            return ResponseEntity.status(HttpStatus.OK).body(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAllClients() {

        try {
            List<Client> clients = clientService.GetAllClients();
            return ResponseEntity.status(HttpStatus.OK).body(clients);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("update/{first_name}/{last_name}/{email}/{phone_number}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable String first_name,
            @PathVariable String last_name, @PathVariable String email,
            @PathVariable String phone_number) {

        try {
            Client updated_client = clientService.UpdateClient(client, first_name, last_name, email, phone_number);
            return ResponseEntity.status(HttpStatus.OK).body(updated_client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{first_name}/{last_name}/{email}/{phone_number}")
    public ResponseEntity<String> deleteClient(@PathVariable String first_name, @PathVariable String last_name,
            @PathVariable String email,
            @PathVariable String phone_number) {

        try {
            clientService.DeleteClient(first_name, last_name, email, phone_number);
            return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting client");
        }
    }

}
