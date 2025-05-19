package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Styles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface StyleRepo extends JpaRepository<Styles, UUID> {}


