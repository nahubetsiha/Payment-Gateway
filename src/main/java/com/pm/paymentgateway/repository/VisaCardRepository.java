package com.pm.paymentgateway.repository;

import com.pm.paymentgateway.model.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisaCardRepository extends JpaRepository<Visa, Long> {
}
