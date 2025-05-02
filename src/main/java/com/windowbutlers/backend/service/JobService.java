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
    
    // Home data used to find the home_id
    Job GetJob(Integer home_id, JobTitle title, Date date_started);

    List<Job> GetAllJobs();
    
    void UpdateJobCompletion(Job job, Integer home_id, JobTitle title, Date date_started, Date date_completed, Integer labor_hours);
    
    void UpdateJobNotes(Job job, Integer home_id, JobTitle title, Date date_started, String notes);
    
    void UpdateJobDifficulty(Job job, Integer home_id, JobTitle title, Date date_started, Rating difficulty);

    void DeleteJob(Integer home_id, JobTitle title, Date date_started);
}
