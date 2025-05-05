package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Payment;
import com.windowbutlers.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {

        paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/singlePayment/{id}")
    public ResponseEntity<?> getSinglePayment(@PathVariable String ID) {

        Payment payment = paymentService.getPayment(ID);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    // Passes Happy Path testing:
    @GetMapping("/get/allPayments")
    public ResponseEntity<?> getAllPayments() {

        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.status(HttpStatus.OK).body(payments);
    }

    // Passes Happy Path testing:
    @PutMapping("update/cost/{id}")
    public ResponseEntity<?> updatePaymentAmount(@PathVariable String ID, @RequestBody String cost) {

        paymentService.updateCost(ID, cost);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Payment Amount for %s to %s", ID, cost));
    }
}
