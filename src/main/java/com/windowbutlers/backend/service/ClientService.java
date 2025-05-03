package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Client;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClientService {
    
    void CreateClient(Client client);

    Client GetClient(String first_name, String last_name, String email, String phone_number);

    List<Client> GetAllClients();

    Client UpdateClient(Client client, String first_name, String last_name, String email, String phone_number);

    void DeleteClient(String first_name, String last_name, String email, String phone_number);
}
