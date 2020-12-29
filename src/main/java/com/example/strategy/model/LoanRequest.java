package com.example.strategy.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class LoanRequest {
    @NotNull
    private BigDecimal loanSum;
    @NotNull
    private LoanType loanType;
}
