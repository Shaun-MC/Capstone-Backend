package com.windowbutlers.backend.controller;

import com.windowbutlers.backend.entity.Payments;
import com.windowbutlers.backend.service.PaymentService;
import com.windowbutlers.backend.validation.ValidUUID;
import com.windowbutlers.backend.dto.requests.CostUpdateRequest;
import com.windowbutlers.backend.dto.requests.PaymentRequest;
import com.windowbutlers.backend.dto.responses.DeleteMessageResponse;
import com.windowbutlers.backend.dto.responses.IDResponse;
import com.windowbutlers.backend.dto.responses.PaymentFullfilledResponse;
import com.windowbutlers.backend.dto.responses.SuccessfulUpdateResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Passes Happy Path testing: 5/11/25
    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody @Valid PaymentRequest payment) {

        IDResponse response = paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/singlePayment/{id}")
    public ResponseEntity<?> getSinglePayment(@PathVariable @ValidUUID String id) {

        Payments payment = paymentService.getPayment(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/allPayments")
    public ResponseEntity<?> getAllPayments() {

        List<Payments> payments = paymentService.getAllPayments();
        return ResponseEntity.status(HttpStatus.OK).body(payments);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/allPaymentsByClient/{clientID}")
    public ResponseEntity<?> getAllPaymentsByClientID(@PathVariable @ValidUUID String clientID) {

        List<Payments> payments = paymentService.getPaymentsByClientID(UUID.fromString(clientID));
        return ResponseEntity.status(HttpStatus.OK).body(payments);
    }

    // Passes Happy Path testing: 5/11/25
    @GetMapping("/get/isPaymentComplete/{id}")
    public ResponseEntity<?> isPaymentFullFilled(@PathVariable @ValidUUID String id) {
        
        PaymentFullfilledResponse response = paymentService.isPaymentFullfilled(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Passes Happy Path testing: 5/11/25
    @PutMapping("update/cost/{id}")
    public ResponseEntity<?> updatePaymentAmount(@PathVariable @ValidUUID String id, @RequestBody @Valid CostUpdateRequest req) {

        SuccessfulUpdateResponse response = paymentService.updateCost(UUID.fromString(id), req);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Passes Happy Path testing: 5/11/25
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable @ValidUUID String id) {

        DeleteMessageResponse response = paymentService.deletePayment(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
