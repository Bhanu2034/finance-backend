package com.finance.finance_backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.finance_backend.repository.FinanceRepository;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final FinanceRepository repository;

    public DashboardController(FinanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/total-records")
    public long totalRecords() {
        return repository.count();
    }
    @GetMapping("/summary")
    public Map<String, Double> getSummary() {

        Double income = repository.getTotalIncome();
        Double expense = repository.getTotalExpense();
        Double balance = income - expense;

        Map<String, Double> response = new HashMap<>();
        response.put("totalIncome", income);
        response.put("totalExpense", expense);
        response.put("balance", balance);

        return response;
    }
}