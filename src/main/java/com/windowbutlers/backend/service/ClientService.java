package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Client;
import com.windowbutlers.backend.dto.ClientRequest;
import com.windowbutlers.backend.validation.*;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface ClientService {
    
    String createClient(@Valid ClientRequest client);

    Client getClient(@ValidUUID String ID);

    List<Client> getAllClients();

    void updateEmail(@ValidUUID String ID, @ValidEmail String email);

    void updatePhoneNumber(@ValidUUID String ID, @ValidPhoneNumber String phoneNumber);

    void deleteClient(@ValidUUID String ID);
}
