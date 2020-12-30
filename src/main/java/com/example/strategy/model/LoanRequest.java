package com.example.strategy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {
    @NotNull
    private BigDecimal loanSum;
    @NotNull
    private LoanType loanType;
}
