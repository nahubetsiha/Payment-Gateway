package com.pm.paymentgateway.service.impl;

import com.pm.paymentgateway.model.Visa;
import com.pm.paymentgateway.service.VisaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaServiceImpl implements VisaService{
    @Override
    public List<Visa> getAllCards() {
        return null;
    }

    @Override
    public Visa getCard(Long cardId) {
        return null;
    }

    @Override
    public Visa addCard(Visa visa) {
        return null;
    }

    @Override
    public Visa updateCard(Long cardId) {
        return null;
    }

    @Override
    public Long deleteCard(Long cardId) {
        return null;
    }
}
