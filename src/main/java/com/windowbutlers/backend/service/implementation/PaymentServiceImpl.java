package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Payment;
import com.windowbutlers.backend.service.PaymentService;
import com.windowbutlers.backend.repository.PaymentRepo;
import com.windowbutlers.backend.dto.PaymentRequest;
import com.windowbutlers.backend.exceptions.DataNotFoundException;
import com.windowbutlers.backend.validation.ValidUUID;
import org.springframework.stereotype.Component;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Component
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public String createPayment(@Valid PaymentRequest request) {

        Payment payment = new Payment();

        payment.setClientID(request.getClientID());
        payment.setCost(request.getCost());

        paymentRepo.save(payment);

        return payment.getID().toString();
    }

    @Override
    public Payment getPayment(@ValidUUID String ID) {

        return paymentRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("GetPayment: Payment not found in the database"));
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public List<Payment> getPaymentsByClientID(@ValidUUID String clientID) {

        return paymentRepo.findByClientId(UUID.fromString(clientID));
    }

    @Override
    public void updateCost(@ValidUUID String ID, Double cost){

        Payment existingPayment = paymentRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("UpdateCost: Payment not found in the database"));
        existingPayment.setCost(cost);
        paymentRepo.save(existingPayment);
    }

    @Override
    public boolean isPaymentFullfilled(@ValidUUID String ID) {
        
        Payment payment = paymentRepo.findById(UUID.fromString(ID)).orElseThrow(() -> new DataNotFoundException("isPaymentFullfilled: Payment not found in the database"));
        return payment.isFullfilled();
    }

    @Override
    public void deletePayment(@ValidUUID String ID) {
        
        paymentRepo.deleteById(UUID.fromString(ID));
    }
}
