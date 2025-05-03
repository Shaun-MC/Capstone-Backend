package com.windowbutlers.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.windowbutlers.backend.entity.ClientHomeAssociation;
import com.windowbutlers.backend.service.ClientHomeAssociationService;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientHomeAssociation")
public class ClientHomeAssociationController {
    
    @Autowired
    private ClientHomeAssociationService clientHomeAssociationService;

    @PostMapping("/create/")
    public ResponseEntity<?> CreateAssociation(@RequestBody ClientHomeAssociation association) {
        
        try {
            clientHomeAssociationService.SaveAssociation(association);
            return ResponseEntity.status(HttpStatus.CREATED).body(association);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/homes/")
    public ResponseEntity<?> GetHomesForClient(@RequestParam String clientId) {
    
        try {

            if (clientId == null || clientId.isBlank() || UUID.fromString(clientId) == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'clientId' cannot be null or blank.");
            }

            List<ClientHomeAssociation> homes = clientHomeAssociationService.GetHomesForClient(UUID.fromString(clientId));
            return ResponseEntity.status(HttpStatus.OK).body(homes);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/clients/")
    public ResponseEntity<?> GetClientsForHome(@RequestParam Integer homeId) {
    
        try {

            if (homeId == null || homeId <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'homeId' cannot be null or blank.");
            }

            List<ClientHomeAssociation> clients = clientHomeAssociationService.GetClientsForHome(homeId);
            return ResponseEntity.status(HttpStatus.OK).body(clients);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/association/")
    public ResponseEntity<?> GetAssociation(@RequestParam String clientId, @RequestParam Integer homeId) {
    
        try {

            if (clientId == null || clientId.isBlank() || UUID.fromString(clientId) == null || homeId == null || homeId <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'clientId' and 'homeId' cannot be null or blank.");
            }

            Optional<ClientHomeAssociation> association = clientHomeAssociationService.GetAssociation(UUID.fromString(clientId), homeId);
            return ResponseEntity.status(HttpStatus.OK).body(association);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/association/")
    public ResponseEntity<?> DeleteAssociation(@RequestParam String clientId, @RequestParam Integer homeId) {
    
        try {

            if (clientId == null || clientId.isBlank() || UUID.fromString(clientId) == null || homeId == null || homeId <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'clientId' and 'homeId' cannot be null or blank.");
            }

            clientHomeAssociationService.DeleteAssociation(UUID.fromString(clientId), homeId);
            return ResponseEntity.status(HttpStatus.OK).body("Association deleted successfully.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
