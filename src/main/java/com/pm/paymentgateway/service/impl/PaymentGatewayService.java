package com.pm.paymentgateway.service.impl;

import com.pm.paymentgateway.exception.EntityNotFoundException;
import com.pm.paymentgateway.exception.InvalidPaymentException;
import com.pm.paymentgateway.model.*;
import com.pm.paymentgateway.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentGatewayService {

    CardService masterCardService;
    CardService visaService;
    RecipientService recipientService;
    TransactionService<MasterCardTransaction> mTransactionService;
    TransactionService<VisaTransaction> vTransactionService;

    public PaymentGatewayService(@Qualifier("masterCardService") CardService<MasterCard> masterCardService, @Qualifier("visaService") CardService<Visa> visaService,
                                 RecipientService recipientService, @Qualifier("MTransactionServiceImpl") TransactionService<MasterCardTransaction> mTransactionService,
                                 @Qualifier("VTransactionServiceImpl") TransactionService<VisaTransaction> vTransactionService){
        this.masterCardService = masterCardService;
        this.visaService = visaService;
        this.recipientService = recipientService;
        this.mTransactionService = mTransactionService;
        this.vTransactionService = vTransactionService;
    }

    public <T> T processTransaction(Order order){

        CardInformation card = order.getCardInformation();
        List<PayTo> payTo = order.getPayTo();


        if(card==null){
            throw new EntityNotFoundException(CardInformation.class);
        }


        Long ccNumber = card.getCardNumber();
        int length = String.valueOf(ccNumber).length();
        char firstDigit = String.valueOf(ccNumber).charAt(0);

        System.out.println("credit card length: "+length + " first digit: "+firstDigit);
        System.out.println(String.valueOf(ccNumber).charAt(0));

        if(length==16 && firstDigit=='5'){
            MasterCard masterCard = new MasterCard();
            masterCard.setName(card.getName());
            masterCard.setPin(card.getPin());
            masterCard.setCardNumber(card.getCardNumber());
            masterCard.setExpDate(card.getExpDate());
//            masterCard.setAvailableBalance(card.getAvailableBalance());
            return (T) masterCardService.processTransaction(masterCard, payTo);

        }
        else if (length==16 && firstDigit=='4'){
            Visa visa = new Visa();
            visa.setName(card.getName());
            visa.setPin(card.getPin());
            visa.setCardNumber(card.getCardNumber());
            visa.setExpDate(card.getExpDate());
//            visa.setAvailableBalance(card.getAvailableBalance());
            return  (T)  visaService.processTransaction(visa, payTo);
        }
        else throw new InvalidPaymentException("Payment Transaction failed");
    }

    public <T> T verifyCard(CardInformation card){
        if(card==null){
            throw new EntityNotFoundException(CardInformation.class);
        }


        Long ccNumber = card.getCardNumber();
        int length = String.valueOf(ccNumber).length();
        char firstDigit = String.valueOf(ccNumber).charAt(0);

        System.out.println("credit card length: "+length + " first digit: "+firstDigit);
        System.out.println(String.valueOf(ccNumber).charAt(0));

        if(length==16 && firstDigit=='5'){
            MasterCard masterCard = (MasterCard) masterCardService.getByCardNumber(ccNumber);
            if(masterCard==null) throw new InvalidPaymentException("Card Not Found");
            masterCard.setName(card.getName());
            masterCard.setPin(card.getPin());
            masterCard.setCardNumber(card.getCardNumber());
            masterCard.setExpDate(card.getExpDate());
            return (T)masterCard;

        }
        else if (length==16 && firstDigit=='4'){
            Visa visa = (Visa) visaService.getByCardNumber(ccNumber);
            if(visa==null) throw new InvalidPaymentException("Card Not Found");
            visa.setName(card.getName());
            visa.setPin(card.getPin());
            visa.setCardNumber(card.getCardNumber());
            visa.setExpDate(card.getExpDate());
            return  (T) visa;
        }
        else throw new InvalidPaymentException("Card Not Accepted");

    }
}
