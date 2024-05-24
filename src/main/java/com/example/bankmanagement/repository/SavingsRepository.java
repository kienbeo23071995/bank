package com.example.bankmanagement.repository;

import com.example.bankmanagement.models.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
}