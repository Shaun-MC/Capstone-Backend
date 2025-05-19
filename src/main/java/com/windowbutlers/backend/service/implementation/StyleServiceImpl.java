package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Styles;
import com.windowbutlers.backend.enums.StyleLabels;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.exceptions.InvalidRequestException;
import com.windowbutlers.backend.service.StyleService;
import com.windowbutlers.backend.repository.StyleRepo;
import com.windowbutlers.backend.dto.requests.CountsUpdateRequest;
import com.windowbutlers.backend.dto.requests.StyleRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;
import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.repository.JobRepo;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class StyleServiceImpl implements StyleService {

    private final StyleRepo styleRepo;
    private final JobRepo jobs;

    public StyleServiceImpl(StyleRepo styleRepo, JobRepo job) {
        this.styleRepo = styleRepo;
        this.jobs = job;
    }

    public IDResponse createStyle(StyleRequest req) {

        Styles style = new Styles();
        Jobs job = jobs.findById(UUID.fromString(req.getJobID())).orElseThrow(() -> new DataNotFoundException("Job not found"));
        
        style.setJob(job);
        style.setLabel(StyleLabels.fromString(req.getLabel()));
        style.setLarge(req.getLarge());
        style.setSmall(req.getSmall());
        
        styleRepo.save(style);
        return new IDResponse(style.getId());
    }

    public Styles getStyle(UUID ID) {
        
        return styleRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("GetJobStyle: Job style ID not found in the database"));
    }

    public String getStyleLabel(UUID ID) {
        
        return styleRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("GetJobStyleLabel: Job style ID not found in the database")).getLabel().toString();
    }

    public List<Styles> getAllStyles() {

        return styleRepo.findAll();
    }

    public SuccessfulUpdateResponse updateCounts(UUID ID, CountsUpdateRequest req) {
        
        Styles existingJobStyle = styleRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("UpdateLargeCount: Job style not found in the database"));
        
        if (existingJobStyle.getLabel() != StyleLabels.WINDOWS && existingJobStyle.getLabel() != StyleLabels.TREES) {
            throw new InvalidRequestException("UpdateLargeCount: Counts are only available for Windows and Trees styles");
        }

        Integer large = req.getLarge();
        Integer small = req.getSmall();

        existingJobStyle.setLarge(large);
        existingJobStyle.setSmall(small);

        styleRepo.save(existingJobStyle);

        return new SuccessfulUpdateResponse("large and small count");
    }

    public DeleteMessageResponse deleteStyle(UUID id) {

        if (!styleRepo.existsById(id)) {
            throw new DataNotFoundException("DeleteStyle: Style ID not found in the database");
        }
        styleRepo.deleteById(id);

        return new DeleteMessageResponse("Style");
    }
}
