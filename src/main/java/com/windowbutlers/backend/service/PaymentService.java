package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.PaymentRequest;
import com.windowbutlers.backend.entity.Payments;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface PaymentService {

    String createPayment(@Valid PaymentRequest payment);

    Payments getPayment(@ValidUUID String ID);

    List<Payments> getAllPayments();

    List<Payments> getPaymentsByClientID(@ValidUUID String clientID);

    void updateCost(@ValidUUID String ID, Double cost);

    boolean isPaymentFullfilled(@ValidUUID String ID);

    void deletePayment(@ValidUUID String ID);
}
