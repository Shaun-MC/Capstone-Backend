package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.dto.ClientHomeAssociationRequest;
import com.windowbutlers.backend.dto.ClientHomeAssociationDTO;
import com.windowbutlers.backend.dto.RelationshipUpdateRequest;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientHomeAssociation")
public class ClientHomeAssociationController {
    
    private final ClientHomeAssociationService chaService;

    public ClientHomeAssociationController(ClientHomeAssociationService chaService) {
        this.chaService = chaService;
    }

    // Passes Happy Path testing: 5/11/25
    @PostMapping("/create")
    public ResponseEntity<?> createAssociation(@RequestBody @Valid ClientHomeAssociationRequest cha) {
        
        IDResponce id = chaService.createAssociation(cha);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/allAssociations")
    public ResponseEntity<?> getAllAssociations() {
        
        List<ClientHomeAssociationDTO> associations = chaService.getAllAssociations();
        return ResponseEntity.status(HttpStatus.OK).body(associations);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/homes/{clientID}")
    public ResponseEntity<?> getHomesForClient(@PathVariable @ValidUUID String clientID) {
        List<ClientHomeAssociationDTO> homes = chaService.getHomesForClient(UUID.fromString(clientID));
        return ResponseEntity.status(HttpStatus.OK).body(homes);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/clients/{homeID}")
    public ResponseEntity<?> getClientsForHome(@PathVariable @ValidUUID String homeID) {
        List<ClientHomeAssociationDTO> clients = chaService.getClientsForHome(UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/association/{clientID}/{homeID}")
    public ResponseEntity<?> getAssociation(@PathVariable String clientID, @PathVariable String homeID) {
        AssociationResponce association = chaService.getAssociation(UUID.fromString(clientID), UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body(association);
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("update/association/{clientID}/{homeID}")
    public ResponseEntity<?> updateAssociation(@PathVariable @ValidUUID String clientID, @PathVariable @ValidUUID String homeID, @RequestBody @Valid RelationshipUpdateRequest req) {
        
        AssociationResponce association = chaService.updateAssociation(UUID.fromString(clientID), UUID.fromString(homeID), req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format(association));
    }

    // Passes Happy Path testing: 5/11/25
    @DeleteMapping("/delete/association/{clientID}/{homeID}")
    public ResponseEntity<?> deleteAssociation(@PathVariable @ValidUUID String clientID, @PathVariable @ValidUUID String homeID) {
        
        DeleteMessageResponce responce = chaService.deleteAssociation(UUID.fromString(clientID), UUID.fromString(homeID));
        return ResponseEntity.status(HttpStatus.OK).body(responce);
    }
}
