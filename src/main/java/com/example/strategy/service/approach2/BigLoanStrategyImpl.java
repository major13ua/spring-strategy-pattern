package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("BIG")
@Slf4j
public class BigLoanStrategyImpl implements ILoanStrategy {
    @Override
    public Boolean process(LoanRequest request) {
        log.info("big impl for {}", request);
        return true;
    }
}
