package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.dto.requests.HomeRequest;
import com.windowbutlers.backend.dto.requests.NotesUpdateRequest;
import com.windowbutlers.backend.dto.requests.PowerSourceLocationUpdateRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface HomeService {
    
    IDResponse createHome(HomeRequest home);

    Homes getHome(UUID id);

    List<Homes> getAllHomes();

    SuccessfulUpdateResponse updateNotes(UUID id, NotesUpdateRequest req);

    SuccessfulUpdateResponse updatePowerSourceLocation(UUID id, PowerSourceLocationUpdateRequest req);

    DeleteMessageResponse deleteHome(UUID id);
}
