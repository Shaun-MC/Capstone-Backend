package com.windowbutlers.backend.service.implementation;

import com.windowbutlers.backend.entity.Payment;
import com.windowbutlers.backend.service.PaymentService;
import com.windowbutlers.backend.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class PaymentServiceImpl implements PaymentService {
    
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Payment CreatePayment(Payment payment) {
        
        try {
            return paymentRepo.save(payment);
        } catch (Exception e) {
            throw new RuntimeException("CreatePayment: Error creating payment: " + e.getMessage());
        }
    }

    @Override
    public Payment GetPayment(UUID id) {
        
        try {
            return paymentRepo.findById(id).orElseThrow(() -> new RuntimeException("GetPayment: Payment not found in the database"));
        } catch (Exception e) {
            throw new RuntimeException("GetPayment: Error retrieving payment: " + e.getMessage());
        }
    }

    @Override
    public List<Payment> GetAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public List<Payment> GetPaymentsByClientId(UUID clientID) {
        
        try {
            return paymentRepo.findByClientId(clientID);
        } catch (Exception e) {
            throw new RuntimeException("GetPaymentsByClientId: Error retrieving payments for client: " + e.getMessage());
        }
    }

    @Override
    public Payment UpdateCost(Payment payment, UUID id, Double cost){

        try {
            Payment existingPayment = paymentRepo.findById(id).orElseThrow(() -> new RuntimeException("UpdateCost: Payment not found in the database"));
            existingPayment.setCost(cost);
            return paymentRepo.save(existingPayment);
        } catch (Exception e) {
            throw new RuntimeException("UpdateCost: Error updating cost: " + e.getMessage());
        }
    }

    @Override
    public boolean isPaymentFullfilled(UUID id) {
        try {
            Payment payment = paymentRepo.findById(id).orElseThrow(() -> new RuntimeException("isPaymentFullfilled: Payment not found in the database"));
            return payment.isFullfilled();
        } catch (Exception e) {
            throw new RuntimeException("isPaymentFullfilled: Error checking payment status: " + e.getMessage());
        }
    }

    @Override
    public void DeletePayment(UUID id) {
        try {
            paymentRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("DeletePayment: Error deleting payment: " + e.getMessage());
        }
    }
}
