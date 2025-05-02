package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.enums.JobTitle;
import com.windowbutlers.backend.enums.Rating;
import com.windowbutlers.backend.entity.Job;
import com.windowbutlers.backend.service.JobService;
import com.windowbutlers.backend.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.sql.Date;

@Component
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;

    private Integer GetJobID(Integer home_id, JobTitle title, Date date_started) {
        return jobRepo.findByHomeIdAndTitleAndDateStarted(home_id, title, date_started).orElseThrow(() -> new RuntimeException("GetJobID: Indexing parameters not found in the database"));
    }

    @Override
    public void CreateJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public Job GetJob(Integer home_id, JobTitle title, Date date_started) {

        try {
            Integer jobID = GetJobID(home_id, title, date_started);

            return jobRepo.findById(jobID).orElseThrow(() -> new RuntimeException("GetJob: Job not found in the database"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Job> GetAllJobs() {
        return jobRepo.findAll();
    }

    @Override
    public void UpdateJobCompletion(Job job, Integer home_id, JobTitle title, Date date_started, Date date_completed, Integer labor_hours) {

        try {

            Integer jobID = GetJobID(home_id, title, date_started);

            // Retrieve the existing job from the database
            Job existingJob = jobRepo.findById(jobID).orElseThrow(() -> new RuntimeException("UpdateJobCompletion: Job not found in the database"));

            existingJob.setDate_completed(date_completed);
            existingJob.setLabor_hours(labor_hours);

            jobRepo.save(existingJob);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void UpdateJobNotes(Job job, Integer home_id, JobTitle title, Date date_started, String notes) {

        try {

            Integer jobID = GetJobID(home_id, title, date_started);

            Job existingJob = jobRepo.findById(jobID).orElseThrow(() -> new RuntimeException("UpdateJobNotes: Job not found in the database"));

            existingJob.setNotes(notes);

            jobRepo.save(existingJob);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void UpdateJobDifficulty(Job job, Integer home_id, JobTitle title, Date date_started, Rating difficulty) {

        try {

            Integer jobID = GetJobID(home_id, title, date_started);

            Job existingJob = jobRepo.findById(jobID).orElseThrow(() -> new RuntimeException("UpdateJobDifficulty: Job not found in the database"));

            existingJob.setDifficulty(job.getDifficulty());

            jobRepo.save(existingJob);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void DeleteJob(Integer home_id, JobTitle title, Date date_started) {

        try {
            Integer jobID = GetJobID(home_id, title, date_started);
            jobRepo.deleteById(jobID);
        } catch (Exception e) {
            throw new RuntimeException("DeleteJob: Job not found");
        }
    }
}
