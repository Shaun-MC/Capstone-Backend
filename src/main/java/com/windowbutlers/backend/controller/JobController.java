package com.windowbutlers.backend.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.windowbutlers.backend.entity.Job;
import com.windowbutlers.backend.service.JobService;
import com.windowbutlers.backend.entity.Home;
import com.windowbutlers.backend.service.HomeService;
import java.util.List;
import java.sql.Date;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private HomeService homeService;

    @PostMapping("/create")
    public ResponseEntity<?> createJob(@RequestBody Job job) {

        try {
            jobService.CreateJob(job);
            return ResponseEntity.status(HttpStatus.CREATED).body(job);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getSingleJob/")
    public ResponseEntity<?> getSingleJob(@RequestParam Integer home_id, @RequestParam String title, @RequestParam Date date_started) {

        if (home_id == null || home_id <= 0 || title == null || title.isBlank() || date_started == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Query parameters 'home_id', 'title', and 'date_started' cannot be null or blank.");
        }

        try {
            Job job = jobService.GetJob(home_id, title, date_started);
            return ResponseEntity.status(HttpStatus.OK).body(job);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<?> getAllJobs() {

        try {
            List<Job> jobs = jobService.GetAllJobs();
            return ResponseEntity.status(HttpStatus.OK).body(jobs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("update/job_completion/")
    public ResponseEntity<?> updateJobCompletion(@RequestBody Job job, @RequestParam String address_line_1, @RequestParam String city, @RequestParam String zip_code, @RequestParam String title,
            @RequestParam Date date_started, @RequestParam Date date_completed, @RequestParam Integer labor_hours) {

        if (address_line_1 == null || address_line_1.isBlank() || city == null || city.isBlank() || zip_code == null || zip_code.isBlank() || title == null || title.isBlank() || date_started == null
                || date_completed == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Query parameters 'address_line_1', 'city', 'zip_code', 'title', 'date_started', and 'date_completed' cannot be null or blank.");
        }

        if (labor_hours == null || labor_hours <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Query parameter 'labor_hours' cannot be null or less than or equal to 0.");
        }

        try {

            Home home = homeService.GetHome(address_line_1, city, zip_code);
            Integer home_id = home.getId();

            jobService.UpdateJobCompletion(job, home_id, title, date_started, date_completed, labor_hours);
            return ResponseEntity.status(HttpStatus.OK).body(job);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("update/job_notes/")
    public ResponseEntity<?> updateJobNotes(@RequestBody Job job, @RequestParam String address_line_1, @RequestParam String city, @RequestParam String zip_code, @RequestParam String title,
            @RequestParam Date date_started, @RequestParam String notes) {

        if (address_line_1 == null || address_line_1.isBlank() || city == null || city.isBlank() || zip_code == null || zip_code.isBlank() || title == null || title.isBlank()
                || date_started == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Query parameters 'address_line_1', 'city', 'zip_code', 'title', 'date_started', and 'notes' cannot be null or blank.");
        }

        try {

            Home home = homeService.GetHome(address_line_1, city, zip_code);
            Integer home_id = home.getId();

            jobService.UpdateJobNotes(job, home_id, title, date_started, notes);
            return ResponseEntity.status(HttpStatus.OK).body(job);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("update/job_difficulty/")
    public ResponseEntity<?> updateJobDifficulty(@RequestBody Job job, @RequestParam String address_line_1, @RequestParam String city, @RequestParam String zip_code, @RequestParam String title,
            @RequestParam Date date_started, @RequestParam String difficulty) {

        if (address_line_1 == null || address_line_1.isBlank() || city == null || city.isBlank() || zip_code == null || zip_code.isBlank() || title == null || title.isBlank()
                || date_started == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Query parameters 'address_line_1', 'city', 'zip_code', 'title', 'date_started', and 'difficulty' cannot be null or blank.");
        }

        try {

            Home home = homeService.GetHome(address_line_1, city, zip_code);
            Integer home_id = home.getId();

            jobService.UpdateJobDifficulty(job, home_id, title, date_started, difficulty);
            return ResponseEntity.status(HttpStatus.OK).body(job);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<String> deleteJob(@RequestParam String address_line_1, @RequestParam String city, @RequestParam String zip_code, @RequestParam String title,
            @RequestParam Date date_started) {

        if (address_line_1 == null || address_line_1.isBlank() || city == null || city.isBlank() || zip_code == null || zip_code.isBlank() || title == null || title.isBlank()
                || date_started == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Query parameters 'address_line_1', 'city', 'zip_code', 'title', and 'date_started' cannot be null or blank.");
        }

        try {

            Home home = homeService.GetHome(address_line_1, city, zip_code);
            Integer home_id = home.getId();

            jobService.DeleteJob(home_id, title, date_started);
            return ResponseEntity.status(HttpStatus.OK).body("Job deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
