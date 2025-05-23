package com.mdacoding.healthcare.ecom.repositories;

import com.mdacoding.healthcare.ecom.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
