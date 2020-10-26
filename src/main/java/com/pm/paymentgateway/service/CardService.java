package com.pm.paymentgateway.service;

import com.pm.paymentgateway.model.MasterCard;
import com.pm.paymentgateway.model.MasterCardTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CardService<C, T>{
    T processTransaction(C masterCard, double amount, Long recipientId);
    List<C> getAllCards();
    Optional<C> getCard(Long cardId);
    C addCard(C masterCard);
    C updateCard(C masterCard, Long cardId);
    Long deleteCard(Long cardId);
}
