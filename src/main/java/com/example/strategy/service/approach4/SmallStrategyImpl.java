package com.example.strategy.service.approach4;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmallStrategyImpl implements IStrategy<LoanType> {

    @Override
    public Boolean process(LoanRequest request) {
        log.info("small impl for {}", request);
        return true;
    }

    @Override
    public LoanType getCode() {
        return LoanType.SMALL;
    }
}
