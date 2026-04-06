package com.finance.finance_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finance.finance_backend.model.FinancialRecord;

public interface FinanceRepository extends JpaRepository<FinancialRecord, Long> {
	  @Query("SELECT COALESCE(SUM(f.amount),0) FROM FinancialRecord f WHERE f.type='income'")
	    Double getTotalIncome();

	    @Query("SELECT COALESCE(SUM(f.amount),0) FROM FinancialRecord f WHERE f.type='expense'")
	    Double getTotalExpense();
}