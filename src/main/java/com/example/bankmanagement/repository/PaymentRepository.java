package com.example.bankmanagement.repository;

import com.example.bankmanagement.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}