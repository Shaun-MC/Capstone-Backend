package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.dto.HomeRequest;
import com.windowbutlers.backend.dto.NotesUpdateRequest;
import com.windowbutlers.backend.dto.PowerSourceLocationUpdateRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface HomeService {
    
    String createHome(HomeRequest home);

    Homes getHome(UUID id);

    List<Homes> getAllHomes();

    String updateNotes(UUID id, NotesUpdateRequest req);

    String updatePowerSourceLocation(UUID id, PowerSourceLocationUpdateRequest req);

    void deleteHome(UUID id);
}
