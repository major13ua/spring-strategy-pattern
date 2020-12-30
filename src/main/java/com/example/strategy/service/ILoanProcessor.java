package com.example.strategy.service;

import com.example.strategy.model.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;

public interface ILoanProcessor {

    LoanProcessorRegistry.LoanProcessorType getCode();
    Boolean process(LoanRequest request);

    @Autowired
    default void register(LoanProcessorRegistry registry){
        registry.register(getCode(), this);
    }
}
