package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Job;
import com.windowbutlers.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.sql.Date;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createJob(@RequestBody Job job) {

        jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(job);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/singleJob/{id}")
    public ResponseEntity<?> getSingleJob(@PathVariable String ID) {

        Job job = jobService.getJob(ID);
        return ResponseEntity.status(HttpStatus.OK).body(job);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allJobs")
    public ResponseEntity<?> getAllJobs() {

        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    // Passes Happy Path testing:
    @PutMapping("/update/dateCompleted/{id}")
    public ResponseEntity<?> updateDateCompleted(@PathVariable String ID, @RequestBody String dateCompleted) {

        jobService.updateJobCompletion(ID, dateCompleted);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Date Completed for %s to %s", ID, dateCompleted));
    }

    // Passes Happy Path testing:
    @PutMapping("/update/jobNotes/{id}")
    public ResponseEntity<?> updateJobNotes(@PathVariable String ID, @RequestBody String jobNotes) {

        jobService.updateJobNotes(ID, jobNotes);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Job Notes for %s to %s", ID, jobNotes));
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
