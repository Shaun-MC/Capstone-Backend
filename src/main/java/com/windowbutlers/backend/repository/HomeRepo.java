package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Homes;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface HomeRepo extends JpaRepository<Homes, UUID> {}
