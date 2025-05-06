package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.PaymentRequest;
import com.windowbutlers.backend.entity.Payment;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import java.util.List;

@Service
public interface PaymentService {

    String createPayment(@Valid PaymentRequest payment);

    Payment getPayment(@ValidUUID String ID);

    List<Payment> getAllPayments();

    List<Payment> getPaymentsByClientID(@ValidUUID String clientID);

    void updateCost(@ValidUUID String ID, Double cost);

    boolean isPaymentFullfilled(@ValidUUID String ID);

    void deletePayment(@ValidUUID String ID);
}
