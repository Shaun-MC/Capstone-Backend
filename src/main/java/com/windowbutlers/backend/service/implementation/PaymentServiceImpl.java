package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Payments;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.service.PaymentService;
import com.windowbutlers.backend.repository.PaymentRepo;
import com.windowbutlers.backend.dto.PaymentRequest;
import com.windowbutlers.backend.dto.CostUpdateRequest;
import com.windowbutlers.backend.entity.Clients;
import com.windowbutlers.backend.repository.ClientRepo;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Component;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Component
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;
    private final ClientRepo clientRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo, ClientRepo clientRepo) {
        this.paymentRepo = paymentRepo;
        this.clientRepo = clientRepo;
    }

    @Override
    public String createPayment(@Valid PaymentRequest request) {

        Payments payment = new Payments();
        Clients client = clientRepo.findById(request.getClientID()).orElseThrow(() -> new DataNotFoundException("Client not found"));

        payment.setClient(client);
        payment.setCost(request.getCost());

        paymentRepo.save(payment);

        return payment.getId().toString();
    }

    @Override
    public Payments getPayment(@ValidUUID String ID) {

        return paymentRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("GetPayment: Payment not found in the database"));
    }

    @Override
    public List<Payments> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public List<Payments> getPaymentsByClientID(@ValidUUID String clientID) {

        List<Payments> payments = paymentRepo.findByClientID(UUID.fromString(clientID));
        if (payments.isEmpty()) {
            throw new DataNotFoundException("No payments found for client ID: " + clientID);
        }
        return payments;
    }

    @Override
    public boolean isPaymentFullfilled(@ValidUUID String ID) {

        Payments payment = paymentRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("isPaymentFullfilled: Payment not found in the database"));
        return payment.isFullfilled();
    }

    @Override
    public Double updateCost(@ValidUUID String ID, @Valid CostUpdateRequest req) {

        Double newCost = req.getCost();

        Payments existingPayment = paymentRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("UpdateCost: Payment not found in the database"));
        existingPayment.setCost(newCost);
        paymentRepo.save(existingPayment);

        return existingPayment.getCost();
    }

    @Override
    public void deletePayment(@ValidUUID String ID) {

        paymentRepo.deleteById(UUID.fromString(ID));
    }
}
