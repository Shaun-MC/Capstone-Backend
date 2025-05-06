package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Home;
import com.windowbutlers.backend.dto.HomeRequest;
import com.windowbutlers.backend.validation.ValidIntegerID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface HomeService {
    
    Integer createHome(@Valid HomeRequest home);

    Home getHome(@ValidIntegerID Integer ID);

    List<Home> getAllHomes();

    void updatePowerSourceLocation(@ValidIntegerID Integer ID, String powerSourceLocation);

    void deleteHome(@ValidIntegerID Integer ID);
}
