package com.pm.paymentgateway.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class MasterCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long masterCardId;
    private Long cardNumber;
    private String name;
//    @DateTimeFormat(pattern = "yyyy-MM")
    private String expDate;
    private int pin;
    private double availableBalance;
    private CardType cardType = CardType.MASTERCARD;

}
