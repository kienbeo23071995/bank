package com.example.bankmanagement.controller;

import com.example.bankmanagement.models.Payment;
import com.example.bankmanagement.models.Receipt;
import com.example.bankmanagement.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/accounting")
public class AccountingController {

    @Autowired
    private AccountingService accountingService;

    @GetMapping("/receipts")
    public String listReceipts(Model model) {
        List<Receipt> receiptList = accountingService.findAllReceipts();
        model.addAttribute("receiptList", receiptList);
        return "accounting/receipts";
    }

    @GetMapping("/payments")
    public String listPayments(Model model) {
        List<Payment> paymentList = accountingService.findAllPayments();
        model.addAttribute("paymentList", paymentList);
        return "accounting/payments";
    }

    @GetMapping("/stats")
    public String showStatistics(Model model) {
        // Logic to get statistics
        model.addAttribute("statistics", new Object()); // Replace with actual statistics object
        return "accounting/stats";
    }
}
