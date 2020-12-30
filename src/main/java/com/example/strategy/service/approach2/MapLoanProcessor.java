package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.service.ILoanProcessor;
import com.example.strategy.service.LoanProcessorRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class MapLoanProcessor implements ILoanProcessor {

    private final Map<String, ILoanStrategy> loanProcessors;

    public MapLoanProcessor(@Autowired Map<String, ILoanStrategy> loanProcessors) {
        this.loanProcessors = loanProcessors;
    }

    @Override
    public LoanProcessorRegistry.LoanProcessorType getCode() {
        return LoanProcessorRegistry.LoanProcessorType.MAP;
    }

    @Override
    public Boolean process(LoanRequest request) {
        ILoanStrategy processor = loanProcessors.get(request.getLoanType().name());
        Objects.requireNonNull(processor, "No processor for " + request.getLoanType() + " found");
        return processor.process(request);
    }

}
