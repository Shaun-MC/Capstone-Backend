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

    private UUID GetClientID(String first_name, String last_name, String email, String phone_number) {
        return clientRepo.findByFirstNameAndLastNameAndOptionalEmailAndPhoneNumber(first_name, last_name, email, phone_number)
                .orElseThrow(() -> new RuntimeException("GetClientID: Indexing parameters not found in the database"));
    }

    @Override
    public void CreateClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    // Define the parameters for the method so that email or phone_number can be
    // null
    public Client GetClient(String first_name, String last_name, String email, String phone_number) {

        try {
            UUID clientID = GetClientID(first_name, last_name, email, phone_number);

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
    public Client UpdateClient(Client client, String first_name, String last_name, String email, String phone_number) {

        try {

            UUID clientID = GetClientID(first_name, last_name, email, phone_number);

            // Retrieve the existing client from the database
            Client existingClient = clientRepo.findById(clientID).orElseThrow(() -> new RuntimeException("UpdateClient: Client not found in the database"));

            existingClient.setFirst_name(client.getFirst_name());
            existingClient.setLast_name(client.getLast_name());
            existingClient.setEmail(client.getEmail());
            existingClient.setPhone_number(client.getPhone_number());
            existingClient.setHas_own_lights(client.getHas_own_lights());

            return clientRepo.save(existingClient);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void DeleteClient(String first_name, String last_name, String email, String phone_number) {

        try {
            UUID clientID = GetClientID(first_name, last_name, email, phone_number);
            clientRepo.deleteById(clientID);
        } catch (Exception e) {
            throw new RuntimeException("DeleteClient: Client not found");
        }
    }
}