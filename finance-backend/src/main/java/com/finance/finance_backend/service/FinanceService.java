package com.finance.finance_backend.service;


import org.springframework.stereotype.Service;

import com.finance.finance_backend.model.FinancialRecord;
import com.finance.finance_backend.repository.FinanceRepository;

import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository repository;

    public FinanceService(FinanceRepository repository) {
        this.repository = repository;
    }

    public FinancialRecord saveRecord(FinancialRecord record) {
        return repository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return repository.findAll();
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord record) {

        FinancialRecord existingRecord = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existingRecord.setType(record.getType());
        existingRecord.setAmount(record.getAmount());
        existingRecord.setCategory(record.getCategory());
        existingRecord.setDate(record.getDate());
        existingRecord.setDescription(record.getDescription());

        return repository.save(existingRecord);
    }
}