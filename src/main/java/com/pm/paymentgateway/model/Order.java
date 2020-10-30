package com.pm.paymentgateway.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private CardInformation cardInformation;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PayTo> payTo;
    private Long orderId;
}
