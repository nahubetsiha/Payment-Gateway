package com.pm.paymentgateway.service;

import com.pm.paymentgateway.model.Visa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisaService {
    List<Visa> getAllCards();
    Visa getCard(Long cardId);
    Visa addCard(Visa visa);
    Visa updateCard(Long cardId);
    Long deleteCard(Long cardId);
}
