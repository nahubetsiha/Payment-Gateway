package com.pm.paymentgateway.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private CardInformation cardInfo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<PayTo> payTo;
    private Long orderId;
}
