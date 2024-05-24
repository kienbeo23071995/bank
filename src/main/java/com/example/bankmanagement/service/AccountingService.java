package com.example.bankmanagement.service;

import com.example.bankmanagement.models.Payment;
import com.example.bankmanagement.models.Receipt;
import com.example.bankmanagement.repository.PaymentRepository;
import com.example.bankmanagement.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountingService {
    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Receipt> findAllReceipts() {
        return receiptRepository.findAll();
    }

    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    public void deleteReceiptById(Long id) {
        receiptRepository.deleteById(id);
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
}
