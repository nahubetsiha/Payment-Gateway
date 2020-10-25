package com.pm.paymentgateway.service.impl;

import com.pm.paymentgateway.exception.EntityNotFoundException;
import com.pm.paymentgateway.exception.InsufficientBalanceException;
import com.pm.paymentgateway.model.MasterCard;
import com.pm.paymentgateway.model.MasterCardTransaction;
import com.pm.paymentgateway.repository.MasterCardRepository;
import com.pm.paymentgateway.service.MasterCardService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MasterCardServiceImpl implements MasterCardService {

    MasterCardRepository masterCardRepository;

    public MasterCardServiceImpl(MasterCardRepository masterCardRepository){
        this.masterCardRepository = masterCardRepository;
    }

    @Override
    public MasterCardTransaction processTransaction(MasterCard masterCard, double amount, Long recipientId){
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

        List<MasterCard> masterCards = masterCardRepository.findAll();

        if(masterCards.isEmpty()) throw new EntityNotFoundException(MasterCard.class);

        return masterCards;
    }

    @Override
    public Optional<MasterCard> getCard(Long cardId) {
//        MasterCard masterCard = masterCardRepository.getOne(cardId);
//        if(masterCard == null) throw new EntityNotFoundException(MasterCard.class, cardId);
//
//        return masterCardRepository.findById(cardId)
//                .orElseThrow(()-> new EntityNotFoundException(MasterCard.class, cardId));
        return masterCardRepository.findById(cardId);
    }

    @Override
    public MasterCard addCard(@Valid MasterCard masterCard) {
        return masterCardRepository.save(masterCard);
    }

    @Override
    public MasterCard updateCard(@Valid MasterCard masterCard, Long cardId) {

        return masterCardRepository.findById(cardId)
                .map(cardToUpdate -> {
                    cardToUpdate.setAvailableBalance(masterCard.getAvailableBalance());
                    cardToUpdate.setCardNumber(masterCard.getCardNumber());
                    cardToUpdate.setExpDate(masterCard.getExpDate());
                    cardToUpdate.setName(masterCard.getName());
                    cardToUpdate.setPin(masterCard.getPin());

                    return cardToUpdate;
                }).orElseThrow(() -> new EntityNotFoundException(MasterCard.class, cardId));
    }

    @Override
    public Long deleteCard(Long cardId) {
        MasterCard masterCard = masterCardRepository.getOne(cardId);
        if(masterCard == null) throw new EntityNotFoundException(MasterCard.class, cardId);

        masterCardRepository.delete(masterCard);
        return cardId;
    }
}
