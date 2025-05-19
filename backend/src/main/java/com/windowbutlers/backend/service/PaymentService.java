package com.windowbutlers.backend.service;

import com.windowbutlers.backend.dto.requests.CostUpdateRequest;
import com.windowbutlers.backend.dto.requests.PaymentRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.PaymentFullfilledResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;
import com.windowbutlers.backend.entity.Payments;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface PaymentService {

    IDResponse createPayment(PaymentRequest payment);

    Payments getPayment(UUID id);

    List<Payments> getAllPayments();

    List<Payments> getPaymentsByClientID(UUID clientID);

    PaymentFullfilledResponse isPaymentFullfilled(UUID id);

    SuccessfulUpdateResponse updateCost(UUID id, CostUpdateRequest req);

    DeleteMessageResponse deletePayment(UUID id);
}
