package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;

public interface ILoanStrategy {
    Boolean process(LoanRequest request);
}
