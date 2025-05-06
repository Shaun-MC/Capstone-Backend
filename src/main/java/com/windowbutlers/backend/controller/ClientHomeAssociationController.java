package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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
        
        List<ClientHomeAssociation> homes = chaService.getHomesForClient(clientID);
        return ResponseEntity.status(HttpStatus.OK).body(homes);
    }

    @GetMapping("/get/clients/{homeID}")
    public ResponseEntity<?> getClientsForHome(@PathVariable Integer homeID) {
        
        List<ClientHomeAssociation> clients = chaService.getClientsForHome(homeID);
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("/get/association/{clientID}/{homeID}")
    public ResponseEntity<?> getAssociation(@PathVariable String clientID, @PathVariable Integer homeID) {
        
        String association = chaService.getAssociation(clientID, homeID);
        return ResponseEntity.status(HttpStatus.OK).body(association);
    }

    // Get all the asscoiations for a home
    @GetMapping("/get/allAssociationsForHome/{homeID}")
    public ResponseEntity<?> getAllAssociationsForHome(@PathVariable Integer homeID) {
        
        List<String> associations = chaService.getAllAssociationsForHome(homeID);
        return ResponseEntity.status(HttpStatus.OK).body(associations);
    }

    @PutMapping("update/association/{clientID}/{homeID}")
    public ResponseEntity<?> updateAssociation(@PathVariable String clientID, @PathVariable Integer homeID, @RequestBody String association) {
        
        chaService.updateAssociation(clientID, homeID, association);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated association to %s successfully", association));
    }

    @DeleteMapping("/delete/association/{clientID}/{homeID}")
    public ResponseEntity<?> deleteAssociation(@PathVariable String clientID, @PathVariable Integer homeID) {
        
        chaService.deleteAssociation(clientID, homeID);
        return ResponseEntity.status(HttpStatus.OK).body("Association deleted successfully");
    }
}
