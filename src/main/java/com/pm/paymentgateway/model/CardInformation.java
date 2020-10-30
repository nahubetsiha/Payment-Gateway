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
public class CardInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private Long cardNumber;
    private int pin;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expDate;
    private double availableBalance;

}
