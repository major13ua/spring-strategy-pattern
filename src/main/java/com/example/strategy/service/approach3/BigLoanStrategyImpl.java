package com.example.strategy.service.approach3;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BigLoanStrategyImpl implements ILoanStrategy {

    @Override
    public LoanType getCode() {
        return LoanType.BIG;
    }

    @Override
    public Boolean process(LoanRequest request) {
        log.info("big impl for {}", request);
        return true;
    }

}
