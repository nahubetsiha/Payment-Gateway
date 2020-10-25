package com.pm.paymentgateway.service;

import com.pm.paymentgateway.exception.EntityNotFoundException;
import com.pm.paymentgateway.model.MasterCard;
import org.springframework.stereotype.Service;

@Service
public class PaymentGateway {

    MasterCardService masterCardService;
    VisaService visaService;
    RecipientService recipientService;
    MTrancsactionService mTrancsactionService;
    VTransactionService vTransactionService;

    public PaymentGateway(MasterCardService masterCardService, VisaService visaService,
                          RecipientService recipientService, MTrancsactionService mTrancsactionService, VTransactionService vTransactionService){
        this.masterCardService = masterCardService;
        this.visaService = visaService;
        this.recipientService = recipientService;
        this.mTrancsactionService = mTrancsactionService;
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
        else throw new EntityNotFoundException();
    }
}
