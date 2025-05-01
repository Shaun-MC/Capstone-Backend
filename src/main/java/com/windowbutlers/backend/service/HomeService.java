package com.windowbutlers.backend.service;
import com.windowbutlers.backend.entity.Client;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface HomeService {
    
    void CreateHomes(Client client);

    Client GetHomes();

    List<Client> GetAllHomes();

    Client UpdateHome();

    void DeleteHome();
}
