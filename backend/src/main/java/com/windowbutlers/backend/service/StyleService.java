package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Styles;
import com.windowbutlers.backend.dto.requests.CountsUpdateRequest;
import com.windowbutlers.backend.dto.requests.StyleRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface StyleService {
    
    IDResponse createStyle(StyleRequest style);

    Styles getStyle(UUID ID);

    String getStyleLabel(UUID ID);

    List<Styles> getAllStyles();

    SuccessfulUpdateResponse updateCounts(UUID ID, CountsUpdateRequest req);

    DeleteMessageResponse deleteStyle(UUID ID);
}
