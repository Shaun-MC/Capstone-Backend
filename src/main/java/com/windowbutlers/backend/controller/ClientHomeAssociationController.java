package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientHomeAssociation")
public class ClientHomeAssociationController {
    
    private final ClientHomeAssociationService chaService;

    public ClientHomeAssociationController(ClientHomeAssociationService chaService) {
        this.chaService = chaService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAssociation(@RequestBody ClientHomeAssociationRequest cha) {
        
        String ID = chaService.createAssociation(cha);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created a new association (%s)".formatted(ID));
    }

    @GetMapping("/get/homes/{clientID}")
    public ResponseEntity<?> getHomesForClient(@PathVariable String clientID) {
        
        List<ClientHomeAssociation> homes = chaService.getHomesForClient(UUID.fromString(clientID));
        return ResponseEntity.status(HttpStatus.OK).body(homes);
    }

    @GetMapping("/get/clients/{homeID}")
    public ResponseEntity<?> getClientsForHome(@PathVariable String homeID) {
        
        List<ClientHomeAssociation> clients = chaService.getClientsForHome(UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("/get/association/{clientID}/{homeID}")
    public ResponseEntity<?> getAssociation(@PathVariable String clientID, @PathVariable String homeID) {
        
        String association = chaService.getAssociation(UUID.fromString(clientID), UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body(association);
    }

    // Get all the asscoiations for a home
    @GetMapping("/get/allAssociationsForHome/{homeID}")
    public ResponseEntity<?> getAllAssociationsForHome(@PathVariable String homeID) {
        
        List<String> associations = chaService.getAllAssociationsForHome(UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body(associations);
    }

    @PutMapping("update/association/{clientID}/{homeID}")
    public ResponseEntity<?> updateAssociation(@PathVariable String clientID, @PathVariable String homeID, @RequestBody String association) {
        
        chaService.updateAssociation(UUID.fromString(clientID), UUID.fromString(homeID), association);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated association to %s successfully", association));
    }

    @DeleteMapping("/delete/association/{clientID}/{homeID}")
    public ResponseEntity<?> deleteAssociation(@PathVariable String clientID, @PathVariable String homeID) {
        
        chaService.deleteAssociation(UUID.fromString(clientID), UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body("Association deleted successfully");
    }
}
