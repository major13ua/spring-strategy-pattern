package com.example.strategy.service.approach3;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import com.example.strategy.service.ILoanProcessor;

public interface ILoanStrategy {

    LoanType getCode();
    Boolean process(LoanRequest request);

    default Boolean evaluate(LoanRequest request) {
        if (getCode() != request.getLoanType()) {
            throw new IllegalArgumentException("Wrong loan type " + request.getLoanType() + ". Only " + getCode() + " supported");
        }
        return process(request);
    }

}
