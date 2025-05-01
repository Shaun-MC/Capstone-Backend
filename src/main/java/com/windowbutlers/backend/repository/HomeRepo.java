package com.windowbutlers.backend.repository;

import com.windowbutlers.backend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepo extends JpaRepository<Client, Integer>{}
