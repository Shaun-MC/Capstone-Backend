package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Home;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface HomeService {
    
    void CreateHome(Home home);

    Home GetHome(String addressLine1, String city, String zipCode);

    List<Home> GetAllHomes();

    Home UpdateHome(Home home, String address_line_1, String city, String zipCode);

    void DeleteHome(String addressLine1, String city, String zipCode);
}
