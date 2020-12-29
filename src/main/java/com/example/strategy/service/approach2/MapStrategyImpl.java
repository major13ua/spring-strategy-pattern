package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class MapStrategyImpl {

    private final Map<String, IApp2LoanProcessor> loanProcessors;

    public MapStrategyImpl (@Autowired Map<String, IApp2LoanProcessor> loanProcessors) {
        this.loanProcessors = loanProcessors;
    }

    public Boolean process(LoanRequest request) {
        IApp2LoanProcessor processor = loanProcessors.get(request.getLoanType());
        Objects.requireNonNull(processor, "No processor for " + request.getLoanType() + " found");
        return processor.process(request);
    }

}
