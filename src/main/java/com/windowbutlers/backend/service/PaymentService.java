package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Payment;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;


@Service
public interface PaymentService {

    void CreatePayment(Payment payment);

    Payment GetPayment(Integer home_id, Integer client_id);

    List<Payment> GetAllPayments();

    Payment UpdateCost(Payment payment, Integer home_id, UUID client_id, Double cost);
}
