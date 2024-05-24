package com.example.bankmanagement.service;

import com.example.bankmanagement.models.Savings;
import com.example.bankmanagement.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    public List<Savings> findAll() {
        return savingsRepository.findAll();
    }

    public Savings save(Savings savings) {
        return savingsRepository.save(savings);
    }

    public void deleteById(Long id) {
        savingsRepository.deleteById(id);
    }

    public Optional<Savings> findById(Long id) {
        return savingsRepository.findById(id);
    }

    public List<Savings> search(String query) {
        return null;
    }
}
