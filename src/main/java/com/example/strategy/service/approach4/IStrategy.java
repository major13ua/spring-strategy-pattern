package com.example.strategy.service.approach4;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;

public interface IStrategy<T extends Enum<T>> {

    T getCode();
    Boolean process(LoanRequest request);

    default Boolean evaluate(LoanRequest request) {
        if (getCode() != request.getLoanType()) {
            throw new IllegalArgumentException("Wrong loan type " + request.getLoanType() + ". Only " + getCode() + " supported");
        }
        return process(request);
    }

}
