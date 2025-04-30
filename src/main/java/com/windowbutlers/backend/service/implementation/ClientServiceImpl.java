package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Client;
import com.windowbutlers.backend.service.ClientService;
import com.windowbutlers.backend.repository.ClientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;

    private Integer GetClientID(String first_name, String last_name, String email, String phone_number) {
        return clientRepo
                .findByFirstNameAndLastNameAndOptionalEmailAndPhoneNumber(first_name, last_name, email, phone_number)
                .orElseThrow(() -> new RuntimeException("GetClientID: Client not found"));
    }

    @Override
    public void CreateClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public Client GetClient(String first_name, String last_name, String email, String phone_number) {
        Integer clientID = -1;

        try {
            clientID = GetClientID(first_name, last_name, email, phone_number);
        } catch (Exception e) {
        }

        return clientRepo.findById(clientID)
                .orElseThrow(() -> new RuntimeException("GetClient: Client not found"));
    }

    @Override
    public List<Client> GetAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client UpdateClient(Client client, String first_name, String last_name, String email, String phone_number) {
        // Retrieve the ID of the client using the composite key
        Integer clientID = GetClientID(first_name, last_name, email, phone_number);

        // Retrieve the existing client from the database
        Client existingClient = clientRepo.findById(clientID)
                .orElseThrow(() -> new RuntimeException("UpdateClient: Client not found"));

        existingClient.setFirst_name(client.getFirst_name());
        existingClient.setLast_name(client.getLast_name());
        existingClient.setEmail(client.getEmail());
        existingClient.setPhone_number(client.getPhone_number());
        existingClient.setHas_own_lights(client.getHas_own_lights());

        return clientRepo.save(existingClient);
    }

    @Override
    public void DeleteClient(String first_name, String last_name, String email, String phone_number) {
        Integer clientID = GetClientID(first_name, last_name, email, phone_number);

        try {
            clientRepo.deleteById(clientID);
        } catch (Exception e) {
            throw new RuntimeException("DeleteClient: Client not found");
        }
    }
}