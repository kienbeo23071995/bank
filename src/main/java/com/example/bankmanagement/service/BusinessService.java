package com.example.bankmanagement.service;

import com.example.bankmanagement.models.BusinessContract;
import com.example.bankmanagement.repository.BusinessContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {
    @Autowired
    private BusinessContractRepository businessContractRepository;

    public List<BusinessContract> findAll() {
        return businessContractRepository.findAll();
    }

    public BusinessContract save(BusinessContract businessContract) {
        return businessContractRepository.save(businessContract);
    }

    public void deleteById(Long id) {
        businessContractRepository.deleteById(id);
    }

    public Optional<BusinessContract> findById(Long id) {
        return businessContractRepository.findById(id);
    }

    public List<BusinessContract> search(String query) {
        return null;
    }
}
