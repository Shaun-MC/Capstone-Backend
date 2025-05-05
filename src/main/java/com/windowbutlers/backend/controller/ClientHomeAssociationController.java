package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientHomeAssociation")
public class ClientHomeAssociationController {
    
    @Autowired
    private ClientHomeAssociationService clientHomeAssociationService;

    @PostMapping("/create")
    public ResponseEntity<?> createAssociation(@RequestBody ClientHomeAssociation association) {
        
        clientHomeAssociationService.saveAssociation(association);
        return ResponseEntity.status(HttpStatus.CREATED).body(association);
    }

    @GetMapping("/get/homes/{clientID}")
    public ResponseEntity<?> getHomesForClient(@PathVariable String clientID) {
        
        List<ClientHomeAssociation> homes = clientHomeAssociationService.getHomesForClient(clientID);
        return ResponseEntity.status(HttpStatus.OK).body(homes);
    }

    @GetMapping("/get/clients/{homeID}")
    public ResponseEntity<?> getClientsForHome(@PathVariable Integer homeID) {
        
        List<ClientHomeAssociation> clients = clientHomeAssociationService.getClientsForHome(homeID);
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("/get/association/{clientID}/{homeID}")
    public ResponseEntity<?> getAssociation(@PathVariable String clientID, @PathVariable Integer homeID) {
        
        String association = clientHomeAssociationService.getAssociation(clientID, homeID);
        return ResponseEntity.status(HttpStatus.OK).body(association);
    }

    // Get all the asscoiations for a home
    @GetMapping("/get/allAssociationsForHome/{homeID}")
    public ResponseEntity<?> getAllAssociationsForHome(@PathVariable Integer homeID) {
        
        List<String> associations = clientHomeAssociationService.getAllAssociationsForHome(homeID);
        return ResponseEntity.status(HttpStatus.OK).body(associations);
    }

    @DeleteMapping("/delete/association/{clientID}/{homeID}")
    public ResponseEntity<?> deleteAssociation(@PathVariable String clientID, @PathVariable Integer homeID) {
        
        clientHomeAssociationService.deleteAssociation(clientID, homeID);
        return ResponseEntity.status(HttpStatus.OK).body("Association %s deleted successfully.");
    }
}
