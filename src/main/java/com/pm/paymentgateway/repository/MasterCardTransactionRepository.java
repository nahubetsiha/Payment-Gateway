package com.pm.paymentgateway.repository;

import com.pm.paymentgateway.model.MasterCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterCardTransactionRepository extends JpaRepository<MasterCardTransaction, Long> {
}
