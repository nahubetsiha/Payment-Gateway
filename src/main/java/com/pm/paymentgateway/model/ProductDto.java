package com.pm.paymentgateway.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    private List<Product> products;
    private Long orderId;
}
