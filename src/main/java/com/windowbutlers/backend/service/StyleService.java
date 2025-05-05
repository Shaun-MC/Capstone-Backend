package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Style;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StyleService {
    
    Style CreateJobStyle(Style jobStyle);

    Style GetJobStyle(Integer ID);

    List<Style> GetAllJobStyles();

    Style UpdateLargeCount(Style jobStyle, Integer large);

    Style UpdateSmallCount(Style jobStyle, Integer small);

    void DeleteJobStyle(Integer ID);
}
