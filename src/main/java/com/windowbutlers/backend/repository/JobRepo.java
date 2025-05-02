package com.windowbutlers.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.windowbutlers.backend.entity.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.Optional;


public interface JobRepo extends JpaRepository<Job, Integer> {
    
    // Doesn't require a join table
    @Query("SELECT j.id FROM Job j JOIN Home h ON j.home_id = h.id WHERE h.id = :home_id AND j.title = :title AND j.date_started = :date_started")
    Optional<Integer> findByHomeIdAndTitleAndDateStarted(
        @Param("home_id") Integer home_id,
        @Param("title") String title,
        @Param("date_started") Date date_started
    );
}
