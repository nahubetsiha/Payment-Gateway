package com.pm.paymentgateway.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class MasterCardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private MasterCard card;
    private double chargedAmount;
    private LocalDate date;
    private String vendor;
}
