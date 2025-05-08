package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.enums.JobTitles;
import com.windowbutlers.backend.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JobRepo extends JpaRepository<Jobs, UUID> {
    
    // Doesn't require a join table
    @Query("SELECT j.id FROM Job j WHERE j.home.id = :homeID AND j.title = :title AND j.dateStarted = :dateStarted")
    Optional<Integer> findByHomeIdAndTitleAndDateStarted(
        @Param("homeID") Integer homeID,
        @Param("title") JobTitles title,
        @Param("dateStarted") Date dateStarted
    );
}
