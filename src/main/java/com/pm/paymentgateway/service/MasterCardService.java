package com.pm.paymentgateway.service;

import com.pm.paymentgateway.model.MasterCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MasterCardService {

    List<MasterCard> getAllCards();
    MasterCard getCard(Long cardId);
    MasterCard addCard(MasterCard masterCard);
    MasterCard updateCard(MasterCard masterCard, Long cardId);
    Long deleteCard(Long cardId);
}
