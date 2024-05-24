package com.example.bankmanagement.repository;

import com.example.bankmanagement.models.BusinessContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessContractRepository extends JpaRepository<BusinessContract, Long> {
}