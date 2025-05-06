package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Style;
import com.windowbutlers.backend.service.StyleService;
import com.windowbutlers.backend.repository.StyleRepo;
import com.windowbutlers.backend.dto.StyleRequest;
import com.windowbutlers.backend.validation.ValidIntegerID;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StyleServiceImpl implements StyleService {

    private final StyleRepo styleRepo;

    public StyleServiceImpl(StyleRepo styleRepo) {
        this.styleRepo = styleRepo;
    }

    public Integer createStyle(@Valid StyleRequest request) {

        Style style = new Style();
        style.setJob(request.getJobID());
        style.setLabel(request.getLabel());
        style.setLarge(request.getLarge());
        style.setSmall(request.getSmall());
        
        styleRepo.save(style);
        return style.getID();
    }

    public Style getStyle(@ValidIntegerID Integer ID) {
        
        return styleRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("GetJobStyle: Job style ID not found in the database"));
    }

    public String getStyleLabel(@ValidIntegerID Integer ID) {
        
        return styleRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("GetJobStyleLabel: Job style ID not found in the database")).getLabel();
    }

    public List<Style> getAllStyles() {

        return styleRepo.findAll();
    }

    public void updateCounts(@ValidIntegerID Integer ID, Integer large, Integer small) {

        Style existingJobStyle = styleRepo.findById(ID).orElseThrow(() -> new RuntimeException("UpdateLargeCount: Job style not found in the database"));
        existingJobStyle.setLarge(large);
        existingJobStyle.setSmall(small);

        styleRepo.save(existingJobStyle);
    }

    public void deleteJobStyle(@ValidIntegerID Integer id) {

        styleRepo.deleteById(id);
    }
}
