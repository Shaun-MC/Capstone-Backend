package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Home;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface HomeService {
    
    void CreateHome(Home home);

    Home GetHome(String address_line1, String city, String zip_code);

    List<Home> GetAllHomes();

    Home UpdateHome(Home home, String address_line_1, String city, String zip_code);

    void DeleteHome(String address_line1, String city, String zip_code);
}
