package com.windowbutlers.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.windowbutlers.backend.entity.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.Optional;


public interface JobRepo extends JpaRepository<Job, Integer> {
    
    // FINISH
    @Query("SELECT j.id FROM Job j")
    Optional<Integer> findByHomeIdAndTitleAndDateStarted(
        @Param("home_id") Integer home_id,
        @Param("title") String title,
        @Param("date_started") Date date_started
    );
}
