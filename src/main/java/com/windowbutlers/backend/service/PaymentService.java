package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Payment;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;

@Service
public interface PaymentService {

    Payment CreatePayment(Payment payment);

    Payment GetPayment(UUID ID);

    List<Payment> GetAllPayments();

    List<Payment> GetPaymentsByClientID(UUID clientID);

    Payment UpdateCost(Payment payment, UUID ID, Double cost);

    boolean isPaymentFullfilled(UUID ID);

    void DeletePayment(UUID ID);
}
