package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends JpaRepository<Home, Integer>{}
