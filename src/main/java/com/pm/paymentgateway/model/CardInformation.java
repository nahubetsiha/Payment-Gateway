package com.pm.paymentgateway.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class CardInformation {
    private Long cardId;
    private Long cardNumber;
    private int pin;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expDate;
    private double availableBalance;

}
