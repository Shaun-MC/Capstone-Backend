package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.dto.JobRequest;
import com.windowbutlers.backend.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.sql.Date;

@RestController
@RequestMapping("/api/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createJob(@RequestBody JobRequest job) {

        String ID = jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Successfully created a new job (%d)", ID));
    }

    // Passes Happy Path testing:
    @GetMapping("/get/singleJob/{id}")
    public ResponseEntity<?> getSingleJob(@PathVariable String id) {

        Jobs job = jobService.getJob(id);
        return ResponseEntity.status(HttpStatus.OK).body(job);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allJobs")
    public ResponseEntity<?> getAllJobs() {

        List<Jobs> jobs = jobService.getAllJobs();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    // Passes Happy Path testing:
    @PutMapping("/update/dateCompleted/{id}")
    public ResponseEntity<?> updateDateCompleted(@PathVariable String id, @RequestBody Date dateCompleted) {

        jobService.updateJobCompletion(id, dateCompleted);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Date Completed for %s to %s", id, dateCompleted));
    }

    // Passes Happy Path testing:
    @PutMapping("/update/jobNotes/{id}")
    public ResponseEntity<?> updateJobNotes(@PathVariable String id, @RequestBody String jobNotes) {

        jobService.updateJobNotes(id, jobNotes);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Job Notes for %s to %s", id, jobNotes));
    }

    // Passes Happy Path testing:
    @PutMapping("/update/jobDifficulty/{id}")
    public ResponseEntity<?> updateJobDifficulty(@PathVariable String ID, @RequestBody String jobDifficulty) {

        jobService.updateJobDifficulty(ID, jobDifficulty);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Job Difficulty for %s to %s", ID, jobDifficulty));
    }

    // Passes Happy Path testing:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable String ID) {

        jobService.deleteJob(ID);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Job %s deleted successfully", ID));
    }
}
