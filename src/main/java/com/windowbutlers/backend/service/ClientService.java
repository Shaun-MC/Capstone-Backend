package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Clients;
import com.windowbutlers.backend.dto.ClientRequest;
import com.windowbutlers.backend.dto.EmailUpdateRequest;
import com.windowbutlers.backend.dto.PhoneNumberUpdateRequest;
import com.windowbutlers.backend.validation.*;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface ClientService {
    
    String createClient(@Valid ClientRequest client);

    Clients getClient(@ValidUUID String ID);

    List<Clients> getAllClients();

    String updateEmail(@ValidUUID String ID, @Valid EmailUpdateRequest email);

    String updatePhoneNumber(@ValidUUID String ID, @Valid PhoneNumberUpdateRequest phoneNumber);

    void deleteClient(@ValidUUID String ID);
}
