package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.dto.HomeRequest;
import com.windowbutlers.backend.dto.NotesUpdateRequest;
import com.windowbutlers.backend.dto.PowerSourceLocationUpdateRequest;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface HomeService {
    
    String createHome(@Valid HomeRequest home);

    Homes getHome(@ValidUUID String ID);

    List<Homes> getAllHomes();

    String updateNotes(@ValidUUID String ID, @Valid NotesUpdateRequest req);

    String updatePowerSourceLocation(@ValidUUID String ID, @Valid PowerSourceLocationUpdateRequest req);

    void deleteHome(@ValidUUID String ID);
}
