package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.enums.JobTitle;
import com.windowbutlers.backend.enums.Rating;
import com.windowbutlers.backend.dto.JobRequest;
import com.windowbutlers.backend.entity.Job;
import com.windowbutlers.backend.service.JobService;
import com.windowbutlers.backend.repository.JobRepo;
import com.windowbutlers.backend.validation.ValidIntegerID;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import java.util.List;
import java.sql.Date;

@Component
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public Integer createJob(@Valid JobRequest request) {

        Job job = new Job();

        job.setTitle(request.getTitle());
        job.setDateStarted(request.getDateStarted());
        job.setDateCompleted(request.getDateCompleted());
        job.setLaborHours(request.getLaborHours());
        job.setNotes(request.getNotes());
        job.setDifficulty(request.getDifficulty());
        job.setHomeID(request.getHomeID());

        jobRepo.save(job);

        return job.getID();
    }

    @Override
    public Job getJob(@ValidIntegerID Integer ID) {

        return jobRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("GetJob: Job not found in the database"));
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    @Override
    // TODO @ValidDate
    public void updateJobCompletion(@ValidIntegerID Integer ID, Date dateCompleted) {

        // TODO:
        // Yes, there is a more efficient way to update a specific field in the database without fetching the entire object. You can use a custom
        // repository method or a JPQL (Java Persistence Query Language)
        // update query to directly update the dateCompleted field for the given ID. This avoids loading the entire Job entity into memory, which can
        // improve performance, especially if the Job entity is large.
        Job job = jobRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("UpdateJobCompletion: Job not found in the database"));
        job.setDateCompleted(dateCompleted);
        jobRepo.save(job);
    }

    @Override
    public void updateJobNotes(@ValidIntegerID Integer ID, String notes) {

        Job job = jobRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("UpdateJobNotes: Job not found in the database"));
        job.setNotes(notes);
        jobRepo.save(job);
    }

    @Override
    // TODO @ValidRating
    public void updateJobDifficulty(@ValidIntegerID Integer ID, String difficulty) {

        Job job = jobRepo.findById(ID).orElseThrow(() -> new DataNotFoundException("UpdateJobDifficulty: Job not found in the database"));
        job.setDifficulty(Rating.valueOf(difficulty.toUpperCase()));
        jobRepo.save(job);
    }

    @Override
    public void deleteJob(@ValidIntegerID Integer ID) {

        jobRepo.deleteById(ID);
    }
}
