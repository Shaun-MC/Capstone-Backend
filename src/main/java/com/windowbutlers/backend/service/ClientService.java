package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Clients;
import com.windowbutlers.backend.dto.requests.ClientRequest;
import com.windowbutlers.backend.dto.requests.EmailUpdateRequest;
import com.windowbutlers.backend.dto.requests.PhoneNumberUpdateRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ClientService {
    
    IDResponse createClient(ClientRequest client);

    Clients getClient(UUID id);

    List<Clients> getAllClients();

    SuccessfulUpdateResponse updateEmail(UUID id, EmailUpdateRequest email);

    SuccessfulUpdateResponse updatePhoneNumber(UUID id, PhoneNumberUpdateRequest phoneNumber);

    DeleteMessageResponse deleteClient(UUID id);
}
