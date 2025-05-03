package com.windowbutlers.backend.service;

import com.windowbutlers.backend.entity.Payment;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;


@Service
public interface PaymentService {

    Payment CreatePayment(Payment payment);

    Payment GetPayment(UUID id);

    List<Payment> GetAllPayments();

    List<Payment> GetPaymentsByClientId(UUID client_id);

    Payment UpdateCost(Payment payment, UUID id, Double cost);

    boolean isPaymentFullfilled(UUID id);

    void DeletePayment(UUID id);
}
