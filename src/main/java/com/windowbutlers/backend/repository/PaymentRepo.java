package com.windowbutlers.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.windowbutlers.backend.entity.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, UUID> {}


