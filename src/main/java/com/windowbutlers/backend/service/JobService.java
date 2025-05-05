package com.windowbutlers.backend.service;

import com.windowbutlers.backend.enums.JobTitle;
import com.windowbutlers.backend.enums.Rating;
import com.windowbutlers.backend.entity.Job;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;

@Service
public interface JobService {
    
    void CreateJob(Job job);
    
    Job GetJob(Integer homeID, JobTitle title, Date dateStarted);

    List<Job> GetAllJobs();
    
    void UpdateJobCompletion(Job job, Integer homeID, JobTitle title, Date dateStarted, Date date_completed, Integer labor_hours);
    
    void UpdateJobNotes(Job job, Integer homeID, JobTitle title, Date dateStarted, String notes);
    
    void UpdateJobDifficulty(Job job, Integer homeID, JobTitle title, Date dateStarted, Rating difficulty);

    void DeleteJob(Integer homeID, JobTitle title, Date dateStarted);
}
