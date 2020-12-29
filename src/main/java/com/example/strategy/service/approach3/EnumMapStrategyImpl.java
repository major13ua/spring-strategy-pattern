package com.example.strategy.service.approach3;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EnumMapStrategyImpl {

    private final Map<LoanType, IApp3LoanProcessor> loanProcessors;

    public EnumMapStrategyImpl(List<IApp3LoanProcessor> processors) {
        loanProcessors = processors.stream()
                .collect(Collectors.toMap(
                        IApp3LoanProcessor::getCode,
                        Function.identity(),
                        (l, r) -> {throw new IllegalArgumentException("Duplicate keys " + l + "and " + r + ".");},
                        () -> new EnumMap<>(LoanType.class)
                ));
    }

    public Boolean process(LoanRequest request) {
        IApp3LoanProcessor processor = loanProcessors.get(request.getLoanType());
        Objects.requireNonNull(processor, "No processor for " + request.getLoanType() + " found");
        return processor.process(request);
    }

}
