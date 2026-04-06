package com.finance.finance_backend.controller;


import org.springframework.web.bind.annotation.*;

import com.finance.finance_backend.model.FinancialRecord;
import com.finance.finance_backend.service.FinanceService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinanceController {

    private final FinanceService service;

    public FinanceController(FinanceService service) {
        this.service = service;
    }

    @PostMapping
    public FinancialRecord addRecord(@Valid @RequestBody FinancialRecord record) {
        return service.saveRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getRecords() {
        return service.getAllRecords();
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
    }
    @PutMapping("/{id}")
    public FinancialRecord updateRecord(@PathVariable Long id,
                                        @RequestBody FinancialRecord record) {
        return service.updateRecord(id, record);
    }
}