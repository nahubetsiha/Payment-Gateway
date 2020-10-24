package com.pm.paymentgateway.service.impl;

import com.pm.paymentgateway.exception.EntityNotFoundException;
import com.pm.paymentgateway.model.Visa;
import com.pm.paymentgateway.repository.VisaRepository;
import com.pm.paymentgateway.service.VisaService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class VisaServiceImpl implements VisaService{

    VisaRepository visaRepository;

    public VisaServiceImpl(VisaRepository visaRepository){
        this.visaRepository = visaRepository;
    }

    @Override
    public List<Visa> getAllCards() {

        List<Visa> visas = visaRepository.findAll();

        if(visas == null) throw new EntityNotFoundException(Visa.class);

        return visas;
    }

    @Override
    public Visa getCard(Long cardId) {
        Visa visa = visaRepository.getOne(cardId);
        if(visa == null) throw new EntityNotFoundException(Visa.class, cardId);

        return visa;
    }

    @Override
    public Visa addCard(@Valid Visa visa) {
        return visaRepository.save(visa);
    }

    @Override
    public Visa updateCard(@Valid Visa visa, Long cardId) {

        return visaRepository.findById(cardId)
                .map(cardToUpdate -> {
                    cardToUpdate.setAvailableBalance(visa.getAvailableBalance());
                    cardToUpdate.setCardNumber(visa.getCardNumber());
                    cardToUpdate.setExpDate(visa.getExpDate());
                    cardToUpdate.setName(visa.getName());
                    cardToUpdate.setPin(visa.getPin());

                    return cardToUpdate;
                }).orElseThrow(() -> new EntityNotFoundException(Visa.class, cardId));
    }

    @Override
    public Long deleteCard(Long cardId) {
        Visa visa = visaRepository.getOne(cardId);
        if(visa == null) throw new EntityNotFoundException(Visa.class, cardId);

        visaRepository.delete(visa);
        return cardId;
    }
}
