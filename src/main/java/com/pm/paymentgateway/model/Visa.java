package com.pm.paymentgateway.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Visa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visaCardId;
    private Long cardNumber;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expDate;
    private int pin;
    private double availableBalance;
}
