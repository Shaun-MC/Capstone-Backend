package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Payment;
import com.windowbutlers.backend.service.PaymentService;
import com.windowbutlers.backend.dto.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class PaymentController {
    
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Passes Happy Path testing:
    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest payment) {

        String ID = paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Successfully created a new payment (%s)", ID));
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

    @GetMapping("/get/allPaymentsByClient/{clientID}")
    public ResponseEntity<?> getAllPaymentsByClientID(@PathVariable String clientID) {

        List<Payment> payments = paymentService.getPaymentsByClientID(clientID);
        return ResponseEntity.status(HttpStatus.OK).body(payments);
    }

    @GetMapping("/get/isPaymentComplete/{id}")
    public ResponseEntity<?> isPaymentFullFilled(@PathVariable String ID) {

        boolean isComplete = paymentService.isPaymentFullfilled(ID);
        return ResponseEntity.status(HttpStatus.OK).body(isComplete);
    }

    // Passes Happy Path testing:
    @PutMapping("update/cost/{id}")
    public ResponseEntity<?> updatePaymentAmount(@PathVariable String ID, @RequestBody Double cost) {

        paymentService.updateCost(ID, cost);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated Payment Amount for %s to %s", ID, cost));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable String ID) {

        paymentService.deletePayment(ID);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted Payment with ID: %s", ID));
    }
}
