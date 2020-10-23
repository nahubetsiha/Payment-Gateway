package com.pm.paymentgateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InsufficientBalanceException extends RuntimeException{
        public InsufficientBalanceException(String message){
            super(message);
        }
}
