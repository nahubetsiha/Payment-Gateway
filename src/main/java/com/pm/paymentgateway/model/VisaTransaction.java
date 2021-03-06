package com.pm.paymentgateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class VisaTransaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Visa card;
    private double chargedAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private Recipient recipient;
}
