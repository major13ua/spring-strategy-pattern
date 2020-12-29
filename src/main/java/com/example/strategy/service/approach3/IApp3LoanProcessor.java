package com.example.strategy.service.approach3;

import com.example.strategy.model.LoanType;
import com.example.strategy.service.ILoanProcessor;

public interface IApp3LoanProcessor extends ILoanProcessor {
    LoanType getCode();
}
