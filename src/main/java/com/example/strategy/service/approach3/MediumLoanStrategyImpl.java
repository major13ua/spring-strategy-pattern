package com.example.strategy.service.approach3;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MediumLoanStrategyImpl implements ILoanStrategy {

    @Override
    public Boolean process(LoanRequest request) {
        log.info("medium impl for {}", request);
        return true;
    }

    @Override
    public LoanType getCode() {
        return LoanType.MEDIUM;
    }

}
