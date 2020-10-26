package com.pm.paymentgateway.controller;

import com.pm.paymentgateway.exception.EntityNotFoundException;
import com.pm.paymentgateway.model.MasterCard;
import com.pm.paymentgateway.service.CardService;
import com.pm.paymentgateway.service.MTransactionService;
import com.pm.paymentgateway.service.MasterCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/mastercard")
public class MasterCardController {

    CardService<MasterCard, MTransactionService> masterCardService;

    public MasterCardController(@Qualifier("masterCardService") CardService masterCardService){
        this.masterCardService = masterCardService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<MasterCard>> getAll(){

        try {
            return new ResponseEntity<>(masterCardService.getAllCards(), HttpStatus.OK);
        } catch (EntityNotFoundException exception){
            throw new EntityNotFoundException(MasterCard.class);
        }

//        return new ResponseEntity<>(masterCardService.getAllCards(), HttpStatus.OK);
    }

    @GetMapping("get/{cardId}")
    public ResponseEntity<MasterCard> getCardById(@PathVariable Long cardId){
//        return new ResponseEntity<>(masterCardService.getCard(cardId), HttpStatus.OK);
        MasterCard masterCard = masterCardService.getCard(cardId)
                .orElseThrow(()-> new EntityNotFoundException(MasterCard.class, cardId));
        return new ResponseEntity<>(masterCard, HttpStatus.OK);
//                .orElseThrow(()-> new EntityNotFoundException(MasterCard.class, cardId)), HttpStatus.OK);
////                .orElseThrow(()-> new EntityNotFoundException(MasterCard.class, cardId));
    }


}
