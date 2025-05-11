package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.dto.JobRequest;
import com.windowbutlers.backend.dto.NotesUpdateRequest;
import com.windowbutlers.backend.dto.LaborHoursUpdateRequest;
import com.windowbutlers.backend.dto.BooleanUpdateRequest;
import com.windowbutlers.backend.dto.DifficultyUpdateRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface JobService {
    
    String createJob(JobRequest job);
    
    Jobs getJob(UUID id);

    List<Jobs> getAllJobs();

    Integer updateLaborHours(UUID id, LaborHoursUpdateRequest req);
    
    String updateJobNotes(UUID id, NotesUpdateRequest req);
    
    String updateJobDifficulty(UUID id, DifficultyUpdateRequest req);

    boolean updateIsPaid(UUID id, BooleanUpdateRequest req);

    void addJobToPayment(UUID jobID, UUID paymentID);

    void deleteJob(UUID id);
}
