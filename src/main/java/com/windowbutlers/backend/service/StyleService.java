package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Styles;
import org.springframework.stereotype.Service;
import com.windowbutlers.backend.dto.CountsUpdateRequest;
import com.windowbutlers.backend.dto.StyleRequest;
import java.util.List;

@Service
public interface StyleService {
    
    Integer createStyle(StyleRequest style);

    Styles getStyle(Integer ID);

    String getStyleLabel(Integer ID);

    List<Styles> getAllStyles();

    List<Integer> updateCounts(Integer ID, CountsUpdateRequest req);

    void deleteStyle(Integer ID);
}
