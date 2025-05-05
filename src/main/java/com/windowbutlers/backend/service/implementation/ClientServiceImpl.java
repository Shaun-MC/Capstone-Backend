package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Client;
import com.windowbutlers.backend.service.ClientService;
import com.windowbutlers.backend.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;

    private UUID GetClientID(String firstName, String lastName, String email, String phoneNumber) {
        return clientRepo.findByFirstNameAndLastNameAndOptionalEmailAndPhoneNumber(firstName, lastName, email, phoneNumber)
                .orElseThrow(() -> new RuntimeException("GetClientID: Indexing parameters not found in the database"));
    }

    @Override
    public void CreateClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    // Define the parameters for the method so that email or phoneNumber can be null
    public Client GetClient(String firstName, String lastName, String email, String phoneNumber) {

        try {
            UUID clientID = GetClientID(firstName, lastName, email, phoneNumber);

            return clientRepo.findById(clientID).orElseThrow(() -> new RuntimeException("GetClient: Client not found in the database"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Client> GetAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client UpdateClient(Client client, String firstName, String lastName, String email, String phoneNumber) {

        try {

            UUID clientID = GetClientID(firstName, lastName, email, phoneNumber);

            // Retrieve the existing client from the database
            Client existingClient = clientRepo.findById(clientID).orElseThrow(() -> new RuntimeException("UpdateClient: Client not found in the database"));

            existingClient.setFirstName(client.getFirstName());
            existingClient.setLastName(client.getLastName());
            existingClient.setEmail(client.getEmail());
            existingClient.setPhoneNumber(client.getPhoneNumber());
            existingClient.setHasOwnLights(client.getHasOwnLights());

            return clientRepo.save(existingClient);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void DeleteClient(String firstName, String lastName, String email, String phoneNumber) {

        try {
            UUID clientID = GetClientID(firstName, lastName, email, phoneNumber);
            clientRepo.deleteById(clientID);
        } catch (Exception e) {
            throw new RuntimeException("DeleteClient: Client not found");
        }
    }
}