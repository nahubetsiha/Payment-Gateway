package com.pm.paymentgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PaymentgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentgatewayApplication.class, args);
    }

}
