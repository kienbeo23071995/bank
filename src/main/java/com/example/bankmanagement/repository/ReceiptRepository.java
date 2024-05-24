package com.example.bankmanagement.repository;

import com.example.bankmanagement.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}