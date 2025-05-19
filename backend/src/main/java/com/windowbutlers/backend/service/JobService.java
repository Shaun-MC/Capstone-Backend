package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.dto.requests.BooleanUpdateRequest;
import com.windowbutlers.backend.dto.requests.DifficultyUpdateRequest;
import com.windowbutlers.backend.dto.requests.JobRequest;
import com.windowbutlers.backend.dto.requests.LaborHoursUpdateRequest;
import com.windowbutlers.backend.dto.requests.NotesUpdateRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface JobService {
    
    IDResponse createJob(JobRequest job);
    
    Jobs getJob(UUID id);

    List<Jobs> getAllJobs();

    SuccessfulUpdateResponse updateLaborHours(UUID id, LaborHoursUpdateRequest req);
    
    SuccessfulUpdateResponse updateJobNotes(UUID id, NotesUpdateRequest req);
    
    SuccessfulUpdateResponse updateJobDifficulty(UUID id, DifficultyUpdateRequest req);

    SuccessfulUpdateResponse updateIsPaid(UUID id, BooleanUpdateRequest req);

    void addJobToPayment(UUID jobID, UUID paymentID);

    DeleteMessageResponse deleteJob(UUID id);
}
