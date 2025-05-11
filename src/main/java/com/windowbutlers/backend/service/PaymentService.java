package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.PaymentRequest;
import com.windowbutlers.backend.dto.CostUpdateRequest;
import com.windowbutlers.backend.dto.PaymentFullfilledResponse;
import com.windowbutlers.backend.entity.Payments;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface PaymentService {

    String createPayment(PaymentRequest payment);

    Payments getPayment(UUID id);

    List<Payments> getAllPayments();

    List<Payments> getPaymentsByClientID(UUID clientID);

    Double updateCost(UUID id, CostUpdateRequest req);

    PaymentFullfilledResponse isPaymentFullfilled(UUID id);

    void deletePayment(UUID id);
}
