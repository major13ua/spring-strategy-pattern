package com.example.strategy.service.approach1;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.service.ILoanProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CaseStrategyImpl implements ILoanProcessor {

    @Override
    public Boolean process(LoanRequest request) {
        switch (request.getLoanType()) {
            case SMALL: return smallCredit(request);
            case MEDIUM: return mediumCredit(request);
            case BIG: return bigCredit(request);
            case HUGE: return hugeCredit(request);
        }
        throw new IllegalArgumentException("Not implemented strategy " +request.getLoanType());
    }

    protected Boolean hugeCredit(LoanRequest request) {
        log.info("huge impl for {}", request);
        return Boolean.TRUE;
    }

    protected Boolean bigCredit(LoanRequest request) {
        log.info("big impl for {}", request);
        return Boolean.TRUE;
    }

    protected Boolean mediumCredit(LoanRequest request) {
        log.info("medium impl for {}", request);
        return Boolean.TRUE;
    }

    protected Boolean smallCredit(LoanRequest request) {
        log.info("small impl for {}", request);
        return Boolean.TRUE;
    }

}
