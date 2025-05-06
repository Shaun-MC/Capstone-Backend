package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Job;
import com.windowbutlers.backend.dto.JobRequest;
import com.windowbutlers.backend.validation.ValidIntegerID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.sql.Date;
import java.util.List;

@Service
public interface JobService {
    
    Integer createJob(@Valid JobRequest job);
    
    Job getJob(@ValidIntegerID Integer ID);

    List<Job> getAllJobs();
    
    //TODO @ValidDate
    void updateJobCompletion(@ValidIntegerID Integer ID, Date dateCompleted);
    
    void updateJobNotes(@ValidIntegerID Integer ID, String jobNotes);
    
    //TODO @ValidRating
    void updateJobDifficulty(@ValidIntegerID Integer ID, String difficulty);

    void deleteJob(@ValidIntegerID Integer ID);
}
