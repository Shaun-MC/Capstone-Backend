package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Styles;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.service.StyleService;
import com.windowbutlers.backend.repository.StyleRepo;
import com.windowbutlers.backend.dto.StyleRequest;
import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.repository.JobRepo;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StyleServiceImpl implements StyleService {

    private final StyleRepo styleRepo;
    private final JobRepo jobs;

    public StyleServiceImpl(StyleRepo styleRepo, JobRepo job) {
        this.styleRepo = styleRepo;
        this.jobs = job;
    }

    public Integer createStyle(StyleRequest request) {

        Styles style = new Styles();
        Jobs job = jobs.findById(request.getJobID()).orElseThrow(() -> new DataNotFoundException("Job not found"));
        style.setJob(job);
        style.setLabel(request.getLabel());
        style.setLarge(request.getLarge());
        style.setSmall(request.getSmall());
        
        styleRepo.save(style);
        return style.getId();
    }

    public Styles getStyle(Integer ID) {
        
        return styleRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("GetJobStyle: Job style ID not found in the database"));
    }

    public String getStyleLabel(Integer ID) {
        
        return styleRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("GetJobStyleLabel: Job style ID not found in the database")).getLabel().toString();
    }

    public List<Styles> getAllStyles() {

        return styleRepo.findAll();
    }

    public List<Integer> updateCounts(Integer ID, StyleRequest req) {
        
        Integer large = req.getLarge();
        Integer small = req.getSmall();

        Styles existingJobStyle = styleRepo.findById(ID).orElseThrow(() -> new RuntimeException("UpdateLargeCount: Job style not found in the database"));
        
        existingJobStyle.setLarge(large);
        existingJobStyle.setSmall(small);

        styleRepo.save(existingJobStyle);

        return List.of(existingJobStyle.getLarge(), existingJobStyle.getSmall());
    }

    public void deleteStyle(Integer id) {

        if (!styleRepo.existsById(id)) {
            throw new DataNotFoundException("DeleteStyle: Style ID not found in the database");
        }
        styleRepo.deleteById(id);
    }
}
