package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Client;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClientService {
    
    void CreateClient(Client client);

    Client GetClient(String firstName, String lastName, String email, String phoneNumber);

    List<Client> GetAllClients();

    Client UpdateClient(Client client, String firstName, String lastName, String email, String phoneNumber);

    void DeleteClient(String firstName, String lastName, String email, String phoneNumber);
}
