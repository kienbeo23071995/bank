package com.example.bankmanagement.service;

import com.example.bankmanagement.models.BusinessContract;
import com.example.bankmanagement.models.Payment;
import com.example.bankmanagement.models.Receipt;
import com.example.bankmanagement.models.Savings;
import com.example.bankmanagement.repository.BusinessContractRepository;
import com.example.bankmanagement.repository.PaymentRepository;
import com.example.bankmanagement.repository.ReceiptRepository;
import com.example.bankmanagement.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private SavingsRepository savingsRepository;

    @Autowired
    private BusinessContractRepository businessContractRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Savings> findAllSavings() {
        return savingsRepository.findAll();
    }

    public List<BusinessContract> findAllBusinessContracts() {
        return businessContractRepository.findAll();
    }

    public List<Receipt> findAllReceipts() {
        return receiptRepository.findAll();
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }
}
