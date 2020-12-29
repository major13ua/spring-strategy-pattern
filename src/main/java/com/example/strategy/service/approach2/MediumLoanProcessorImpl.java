package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("MEDIUM")
@Slf4j
public class MediumLoanProcessorImpl implements IApp2LoanProcessor{
    @Override
    public Boolean process(LoanRequest request) {
        log.info("medium impl for {}", request);
        return true;
    }
}
