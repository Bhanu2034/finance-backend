package com.finance.finance_backend.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Type is required")
    private String type;   // income or expense
    @Positive(message = "Amount must be positive")
    private double amount;
    @NotBlank(message = "Category is required")
    private String category;
    @NotNull(message = "Date is required")
    private LocalDate date;
    private String description;
}