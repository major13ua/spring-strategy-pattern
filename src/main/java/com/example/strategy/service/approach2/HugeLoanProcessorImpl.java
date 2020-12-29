package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("HUGE")
@Slf4j
public class HugeLoanProcessorImpl implements IApp2LoanProcessor{
    @Override
    public Boolean process(LoanRequest request) {
        log.info("huge impl for {}", request);
        return true;
    }
}
