package com.pm.paymentgateway.controller;

import com.pm.paymentgateway.exception.InvalidPaymentException;
import com.pm.paymentgateway.model.CardInformation;
import com.pm.paymentgateway.service.impl.PaymentGatewayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/payment")
public class PaymentGateway {

    PaymentGatewayService paymentGatewayService;

    public PaymentGateway(PaymentGatewayService paymentGatewayService){
        this.paymentGatewayService = paymentGatewayService;
    }

    @PostMapping("/process-transaction/{recipientId}")
    public <T> ResponseEntity<T> processTransaction(@RequestBody CardInformation card, double amount, @PathVariable Long recipientId){

        try {
            return new ResponseEntity<T>((T) paymentGatewayService.processTransaction(card, amount, recipientId), HttpStatus.OK);
        } catch (InvalidPaymentException exception){
            throw new InvalidPaymentException("Payment Transaction failed");
        }

    }

}
