package com.pm.paymentgateway.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class VisaTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Visa card;
    private double chargedAmount;
    private LocalDate date;
    @OneToOne
    private Recipient recipient;
}
