package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.dto.JobRequest;
import com.windowbutlers.backend.dto.NotesUpdateRequest;
import com.windowbutlers.backend.dto.LaborHoursUpdateRequest;
import com.windowbutlers.backend.dto.DifficultyUpdateRequest;
import com.windowbutlers.backend.dto.BooleanUpdateRequest;
import com.windowbutlers.backend.service.JobService;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Passes Happy Path testing: 5/11/25
    @PostMapping("/create")
    public ResponseEntity<?> createJob(@RequestBody @Valid JobRequest job) {

        String id = jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Successfully created a new job (%s)", id));
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/singleJob/{id}")
    public ResponseEntity<?> getSingleJob(@PathVariable @ValidUUID String id) {

        Jobs job = jobService.getJob(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(job);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/allJobs")
    public ResponseEntity<?> getAllJobs() {

        List<Jobs> jobs = jobService.getAllJobs();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("update/laborHours/{id}")
    public ResponseEntity<?> updateLaborHours(@PathVariable @ValidUUID String id, @RequestBody @Valid LaborHoursUpdateRequest req) {

        Integer laborHours = jobService.updateLaborHours(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Job Labor Hours for %s to %s", id, laborHours));
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("/update/notes/{id}")
    public ResponseEntity<?> updateJobNotes(@PathVariable @ValidUUID String id, @RequestBody @Valid NotesUpdateRequest req) {

        String notes = jobService.updateJobNotes(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Job Notes for %s to %s", id, notes));
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("/update/difficulty/{id}")
    public ResponseEntity<?> updateJobDifficulty(@PathVariable @ValidUUID String id, @RequestBody @Valid DifficultyUpdateRequest req) {

        String difficulty = jobService.updateJobDifficulty(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Job Difficulty for %s to %s", id, difficulty));
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("update/isPaid/{id}")
    public ResponseEntity<?> updateIsPaid(@PathVariable @ValidUUID String id, @RequestBody @Valid BooleanUpdateRequest req) {

        boolean isPaid = jobService.updateIsPaid(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Job %s to %s", id, isPaid));
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("update/addJobToPayment/{jobID}/{paymentID}")
    public ResponseEntity<?> addJobToPayment(@PathVariable @ValidUUID String jobID, @PathVariable String paymentID) {
        
        jobService.addJobToPayment(UUID.fromString(jobID), UUID.fromString(paymentID));
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Added Job %s to Payment %s", jobID, paymentID));
    }

    // Passes Happy Path testing: 5/11/25
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable @ValidUUID String id) {

        jobService.deleteJob(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Job %s deleted successfully", id));
    }
}
