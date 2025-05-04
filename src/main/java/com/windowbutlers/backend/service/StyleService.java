package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Style;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StyleService {
    
    Style CreateJobStyle(Style jobStyle);

    Style GetJobStyle(Integer id);

    List<Style> GetAllJobStyles();

    Style UpdateLargeCount(Style jobStyle, Integer large_count);

    Style UpdateSmallCount(Style jobStyle, Integer medium_count);

    void DeleteJobStyle(Integer id);
}
