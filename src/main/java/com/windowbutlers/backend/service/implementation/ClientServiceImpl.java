package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Client;
import com.windowbutlers.backend.dto.ClientRequest;
import com.windowbutlers.backend.service.ClientService;
import com.windowbutlers.backend.repository.ClientRepo;
import com.windowbutlers.backend.validation.*;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Component
@Validated
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public String createClient(@Valid ClientRequest request) {
        
        Client client = new Client();
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setHasOwnLights(request.getHasOwnLights());

        clientRepo.save(client);

        return client.getID().toString();
    }

    @Override
    public Client getClient(@ValidUUID String ID) {
        
        return clientRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("GetClient: Client ID not found in the database"));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public void updateEmail(@ValidUUID String ID, @ValidEmail String email) {
        
        Client client = clientRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("UpdateEmail: Client ID not found in the database"));
        client.setEmail(email);
        clientRepo.save(client);
    }

    @Override
    public void updatePhoneNumber(@ValidUUID String ID, @ValidPhoneNumber String phoneNumber) {
        
        Client client = clientRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new RuntimeException("UpdatePhoneNumber: Client ID not found in the database"));
        client.setPhoneNumber(phoneNumber);
        clientRepo.save(client);
    }

    @Override
    public void deleteClient(String ID) {

        clientRepo.deleteById(UUID.fromString(ID));
    }
}