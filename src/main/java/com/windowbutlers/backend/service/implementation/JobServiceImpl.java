package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.enums.JobRatings;
import com.windowbutlers.backend.dto.JobRequest;
import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.repository.HomeRepo;
import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.service.JobService;
import com.windowbutlers.backend.repository.JobRepo;
import com.windowbutlers.backend.validation.ValidUUID;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import java.util.List;
import java.sql.Date;
import java.util.UUID;

@Component
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;
    private final HomeRepo homeRepo;

    public JobServiceImpl(JobRepo jobRepo, HomeRepo homeRepo) {
        this.jobRepo = jobRepo;
        this.homeRepo = homeRepo;
    }

    @Override
    public String createJob(@Valid JobRequest request) {

        Jobs job = new Jobs();
        Homes home = homeRepo.findById(UUID.fromString(request.getHomeID())).orElseThrow(() -> new DataNotFoundException("Home not found"));

        job.setTitle(request.getTitle());
        job.setDateStarted(request.getDateStarted());
        job.setDateCompleted(request.getDateCompleted());
        job.setLaborHours(request.getLaborHours());
        job.setNotes(request.getNotes());
        job.setDifficulty(request.getDifficulty());
        job.setHome(home);

        jobRepo.save(job);

        return job.getId().toString();
    }

    @Override
    public Jobs getJob(@ValidUUID String ID) {

        return jobRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("GetJob: Job not found in the database"));
    }

    @Override
    public List<Jobs> getAllJobs() {
        return jobRepo.findAll();
    }

    @Override
    // TODO @ValidDate
    public void updateJobCompletion(@ValidUUID String ID, Date dateCompleted) {

        // TODO:
        // Yes, there is a more efficient way to update a specific field in the database without fetching the entire object. You can use a custom
        // repository method or a JPQL (Java Persistence Query Language)
        // update query to directly update the dateCompleted field for the given ID. This avoids loading the entire Job entity into memory, which can
        // improve performance, especially if the Job entity is large.
        Jobs job = jobRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("UpdateJobCompletion: Job not found in the database"));
        job.setDateCompleted(dateCompleted);
        jobRepo.save(job);
    }

    @Override
    public void updateJobNotes(@ValidUUID String ID, String notes) {

        Jobs job = jobRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("UpdateJobNotes: Job not found in the database"));
        job.setNotes(notes);
        jobRepo.save(job);
    }

    @Override
    // TODO @ValidRating
    public void updateJobDifficulty(@ValidUUID String ID, String difficulty) {

        Jobs job = jobRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("UpdateJobDifficulty: Job not found in the database"));
        job.setDifficulty(JobRatings.valueOf(difficulty.toUpperCase()));
        jobRepo.save(job);
    }

    @Override
    public void deleteJob(@ValidUUID String ID) {

        jobRepo.deleteById(UUID.fromString(ID));
    }
}
