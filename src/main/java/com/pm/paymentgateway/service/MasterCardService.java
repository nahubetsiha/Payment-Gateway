package com.pm.paymentgateway.service;

import com.pm.paymentgateway.model.MasterCard;
import com.pm.paymentgateway.model.MasterCardTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MasterCardService {

    MasterCardTransaction processTransaction(MasterCard masterCard, double amount, Long recipientId);
    List<MasterCard> getAllCards();
    Optional<MasterCard> getCard(Long cardId);
    MasterCard addCard(MasterCard masterCard);
    MasterCard updateCard(MasterCard masterCard, Long cardId);
    Long deleteCard(Long cardId);
}
