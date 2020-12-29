package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("SMALL")
@Slf4j
public class SmallLoanProcessorImpl implements IApp2LoanProcessor{
    @Override
    public Boolean process(LoanRequest request) {
        if (LoanType.SMALL != request.getLoanType()) {
            throw new IllegalArgumentException("Only LoanType.SMALL supported");
        }

        log.info("small impl for {}", request);
        return true;
    }
}
