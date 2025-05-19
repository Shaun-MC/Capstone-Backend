package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.enums.JobRatings;
import com.windowbutlers.backend.enums.JobTitles;
import com.windowbutlers.backend.dto.DifficultyUpdateRequest;
import com.windowbutlers.backend.dto.JobRequest;
import com.windowbutlers.backend.dto.LaborHoursUpdateRequest;
import com.windowbutlers.backend.dto.NotesUpdateRequest;
import com.windowbutlers.backend.dto.BooleanUpdateRequest;
import com.windowbutlers.backend.entity.Homes;
import com.windowbutlers.backend.entity.Jobs;
import com.windowbutlers.backend.entity.Payments;
import com.windowbutlers.backend.repository.HomeRepo;
import com.windowbutlers.backend.repository.JobRepo;
import com.windowbutlers.backend.repository.PaymentRepo;
import com.windowbutlers.backend.service.JobService;
import com.windowbutlers.backend.utils.DateConverter;
import org.springframework.stereotype.Component;
import java.util.List;
import java.sql.Date;
import java.util.UUID;

@Component
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;
    private final HomeRepo homeRepo;
    private final PaymentRepo paymentRepo;

    public JobServiceImpl(JobRepo jobRepo, HomeRepo homeRepo, PaymentRepo paymentRepo) {
        this.jobRepo = jobRepo;
        this.homeRepo = homeRepo;
        this.paymentRepo = paymentRepo;
    }

    @Override
    public String createJob(JobRequest request) {

        // Format the date string to a Date object - validated by @ValidDate in request object
        Date dateCompleted = DateConverter.convertStringToSqlDate(request.getDateCompleted());

        Jobs job = new Jobs();
        Homes home = homeRepo.findById(UUID.fromString(request.getHomeID())).orElseThrow(() -> new DataNotFoundException("Home not found"));

        job.setHome(home);
        job.setTitle(JobTitles.fromString(request.getTitle()));
        job.setDateCompleted(dateCompleted);
        job.setLaborHours(request.getLaborHours());
        job.setNotes(request.getNotes());
        job.setDifficulty(JobRatings.fromString(request.getDifficulty()));
        job.setIsPaid(request.getIsPaid()); 

        jobRepo.save(job);

        return job.getId().toString();
    }

    @Override
    public Jobs getJob(UUID id) {

        return jobRepo.findById(id).orElseThrow(() -> new DataNotFoundException("GetJob: Job not found in the database"));
    }

    @Override
    public List<Jobs> getAllJobs() {
        return jobRepo.findAll();
    }

    @Override
    public Integer updateLaborHours(UUID id, LaborHoursUpdateRequest req) {

        Integer laborHours = req.getLaborHours();
        Jobs job = jobRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateJobLaborHours: Job not found in the database"));
        
        job.setLaborHours(laborHours);
        jobRepo.save(job);

        return job.getLaborHours();
    }

    @Override
    public String updateJobNotes(UUID id, NotesUpdateRequest req) {

        String notes = req.getNotes();
        Jobs job = jobRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateJobNotes: Job not found in the database"));
        
        job.setNotes(notes);
        jobRepo.save(job);

        return job.getNotes();
    }

    @Override
    public String updateJobDifficulty(UUID id, DifficultyUpdateRequest req) {

        Jobs job = jobRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateJobDifficulty: Job not found in the database"));
        
        job.setDifficulty(JobRatings.fromString(req.getDifficulty()));
        jobRepo.save(job);

        return job.getDifficulty().toString();
    }

    @Override
    public void addJobToPayment(UUID jobID, UUID paymentID) {

        Jobs job = jobRepo.findById(jobID).orElseThrow(() -> new DataNotFoundException("AddJobToPayment: Job not found in the database"));
        Payments payment = paymentRepo.findById(paymentID).orElseThrow(() -> new DataNotFoundException("AddJobToPayment: Payment not found in the database"));

        job.setPayment(payment);
        payment.getJobs().add(job);

        jobRepo.save(job);
    }

    @Override
    public boolean updateIsPaid(UUID id, BooleanUpdateRequest req) {

        Boolean isPaid = req.getValue();
        Jobs job = jobRepo.findById(id).orElseThrow(() -> new DataNotFoundException("UpdateJobIsPaid: Job not found in the database"));
        
        job.setIsPaid(isPaid);
        jobRepo.save(job);

        return job.getIsPaid();
    }

    @Override
    public void deleteJob(UUID id) {

        if (!paymentRepo.findById(id).isPresent()) {
            throw new DataNotFoundException("DeleteJob: Job not found in the database");
        }
        jobRepo.deleteById(id);
    }
}
