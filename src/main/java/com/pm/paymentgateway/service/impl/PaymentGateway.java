package com.pm.paymentgateway.service.impl;

import com.pm.paymentgateway.exception.EntityNotFoundException;
import com.pm.paymentgateway.model.MasterCard;
import com.pm.paymentgateway.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentGateway {

    CardService masterCardService;
    CardService visaService;
    RecipientService recipientService;
    MTransactionService mTransactionService;
    VTransactionService vTransactionService;

    public PaymentGateway(@Qualifier("masterCardService") CardService masterCardService, @Qualifier("visaService") CardService visaService,
                          RecipientService recipientService, @Qualifier("MTransactionService") MTransactionService mTransactionService, @Qualifier("VTransactionService") VTransactionService vTransactionService){
        this.masterCardService = masterCardService;
        this.visaService = visaService;
        this.recipientService = recipientService;
        this.mTransactionService = mTransactionService;
        this.vTransactionService = vTransactionService;
    }

    public void verifyCard(MasterCard masterCard, double amount, Long recipientId){
        Long ccNumber = masterCard.getCardNumber();
        int length = String.valueOf(ccNumber).length();
        int firstDigit = String.valueOf(ccNumber).charAt(0);


        if(length==16 && firstDigit==5){
            masterCardService.processTransaction(masterCard, amount, recipientId);
        }
        else if (length==16 && firstDigit==4){

        }
        else throw new EntityNotFoundException(MasterCard.class);
    }
}
