package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Clients;
import com.windowbutlers.backend.dto.ClientRequest;
import com.windowbutlers.backend.dto.EmailUpdateRequest;
import com.windowbutlers.backend.dto.PhoneNumberUpdateRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ClientService {
    
    String createClient(ClientRequest client);

    Clients getClient(UUID id);

    List<Clients> getAllClients();

    String updateEmail(UUID id, EmailUpdateRequest email);

    String updatePhoneNumber(UUID id, PhoneNumberUpdateRequest phoneNumber);

    void deleteClient(UUID id);
}
