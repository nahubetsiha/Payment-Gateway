package com.pm.paymentgateway.service.impl;

import com.pm.paymentgateway.exception.InsufficientBalanceException;
import com.pm.paymentgateway.model.MasterCard;
import com.pm.paymentgateway.model.MasterCardTransaction;
import com.pm.paymentgateway.repository.MasterCardRepository;
import com.pm.paymentgateway.service.MasterCardService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MasterCardServiceImpl implements MasterCardService {

    MasterCardRepository masterCardRepository;

    public MasterCardServiceImpl(MasterCardRepository masterCardRepository){
        this.masterCardRepository = masterCardRepository;
    }

    public MasterCardTransaction processTransaction(MasterCard masterCard, double amount){
//        if(masterCard.getAvailableBalance()-amount < 0) throw new InsufficientBalanceException("Insufficient balance to complete transaction");
//
//        masterCard.setAvailableBalance(masterCard.getAvailableBalance()-amount);
//        MasterCardTransaction masterCardTransaction = new MasterCardTransaction();
//        masterCardTransaction.setCard(masterCard);
//        masterCardTransaction.setChargedAmount(amount);
//        masterCardTransaction.setDate(LocalDate.now());
//        masterCardTransaction.setVendor("Shopping Cart");
        return null;

    }


    @Override
    public List<MasterCard> getAllCards() {
        return masterCardRepository.findAll();
    }

    @Override
    public MasterCard getCard(Long cardId) {
        return null;
    }

    @Override
    public MasterCard addCard(MasterCard masterCard) {
        return null;
    }

    @Override
    public MasterCard updateCard(Long cardId) {
        return null;
    }

    @Override
    public Long deleteCard(Long cardId) {
        return null;
    }
}
