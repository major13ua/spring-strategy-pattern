package com.example.strategy.service;

import com.example.strategy.model.LoanRequest;

public interface ILoanProcessor {
    Boolean process(LoanRequest request);
}
