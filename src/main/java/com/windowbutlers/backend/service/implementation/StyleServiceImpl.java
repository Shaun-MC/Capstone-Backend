package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Style;
import com.windowbutlers.backend.service.StyleService;
import com.windowbutlers.backend.repository.StyleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleRepo styleRepo;

    public Style CreateJobStyle(Style jobStyle) {

        try {
            return styleRepo.save(jobStyle);
        } catch (Exception e) {
            throw new RuntimeException("CreateChristmasLighting: Error creating Christmas lighting: " + e.getMessage());
        }
    }

    public Style GetJobStyle(Integer id) {

        try {
            return styleRepo.findById(id).orElseThrow(() -> new RuntimeException("GetJobStyle: Job style not found in the database"));
        } catch (Exception e) {
            throw new RuntimeException("GetJobStyle: Error retrieving job style: " + e.getMessage());
        }
    }

    public List<Style> GetAllJobStyles() {

        try {
            return styleRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("GetAllJobStyles: Error retrieving all job styles: " + e.getMessage());
        }
    }

    public Style UpdateLargeCount(Style jobStyle, Integer large) {

        try {
            Style existingJobStyle = styleRepo.findById(jobStyle.getId()).orElseThrow(() -> new RuntimeException("UpdateLargeCount: Job style not found in the database"));
            existingJobStyle.setLarge(large);
            return styleRepo.save(existingJobStyle);
        } catch (Exception e) {
            throw new RuntimeException("UpdateLargeCount: Error updating large count: " + e.getMessage());
        }
    }

    public Style UpdateSmallCount(Style jobStyle, Integer small) {

        try {
            Style existingJobStyle = styleRepo.findById(jobStyle.getId()).orElseThrow(() -> new RuntimeException("UpdateSmallCount: Job style not found in the database"));
            existingJobStyle.setSmall(small);
            return styleRepo.save(existingJobStyle);
        } catch (Exception e) {
            throw new RuntimeException("UpdateSmallCount: Error updating small count: " + e.getMessage());
        }
    }

    public void DeleteJobStyle(Integer id) {

        try {
            styleRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("DeleteJobStyle: Error deleting job style: " + e.getMessage());
        }
    }
}
