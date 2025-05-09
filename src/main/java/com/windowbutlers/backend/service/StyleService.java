package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Styles;
import org.springframework.stereotype.Service;
import com.windowbutlers.backend.dto.StyleRequest;
import com.windowbutlers.backend.validation.ValidIntegerID;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface StyleService {
    
    Integer createStyle(@Valid StyleRequest style);

    Styles getStyle(@ValidIntegerID Integer ID);

    String getStyleLabel(@ValidIntegerID Integer ID);

    List<Styles> getAllStyles();

    void updateCounts(@ValidIntegerID Integer ID, Integer large, Integer small);

    void deleteStyle(@ValidIntegerID Integer ID);
}
