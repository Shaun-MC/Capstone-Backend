package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.dto.JobRequest;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.sql.Date;
import java.util.List;

@Service
public interface JobService {
    
    String createJob(@Valid JobRequest job);
    
    Jobs getJob(@ValidUUID String ID);

    List<Jobs> getAllJobs();
    
    //TODO @ValidDate
    void updateJobCompletion(@ValidUUID String ID, Date dateCompleted);
    
    void updateJobNotes(@ValidUUID String ID, String jobNotes);
    
    //TODO @ValidRating
    void updateJobDifficulty(@ValidUUID String ID, String difficulty);

    void deleteJob(@ValidUUID String ID);
}
