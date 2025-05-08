package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.dto.HomeRequest;
import com.windowbutlers.backend.validation.ValidIntegerID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface HomeService {
    
    String createHome(@Valid HomeRequest home);

    Homes getHome(@ValidIntegerID String ID);

    List<Homes> getAllHomes();

    void updatePowerSourceLocation(@ValidIntegerID String ID, String powerSourceLocation);

    void deleteHome(@ValidIntegerID String ID);
}
