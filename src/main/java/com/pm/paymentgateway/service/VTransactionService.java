package com.pm.paymentgateway.service;

import com.pm.paymentgateway.model.VisaTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VTransactionService {
    List<VisaTransaction> getAllTransactions();
    Optional<VisaTransaction> getTransaction(Long transactionId);
    VisaTransaction addTransaction(VisaTransaction visaTransaction);
    VisaTransaction updateTransaction(VisaTransaction visaTransaction, Long transactionId);
    Long deleteTransaction(Long transactionId);
}
