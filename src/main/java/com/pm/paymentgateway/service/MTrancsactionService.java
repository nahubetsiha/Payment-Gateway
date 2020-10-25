package com.pm.paymentgateway.service;

import com.pm.paymentgateway.model.MasterCardTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MTrancsactionService {
    List<MasterCardTransaction> getAllTransactions();
    Optional<MasterCardTransaction> getTransaction(Long transactionId);
    MasterCardTransaction addTransaction(MasterCardTransaction masterCardTransaction);
    MasterCardTransaction updateTransaction(MasterCardTransaction masterCardTransaction, Long transactionId);
    Long deleteTransaction(Long transactionId);
}
