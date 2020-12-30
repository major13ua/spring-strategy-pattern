package com.example.strategy.service.approach3;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import com.example.strategy.service.ILoanProcessor;
import com.example.strategy.service.LoanProcessorRegistry;
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
public class EnumMapLoanProcessor implements ILoanProcessor {

    private final Map<LoanType, ILoanStrategy> loanProcessors;

    public EnumMapLoanProcessor(List<ILoanStrategy> processors) {
        loanProcessors = processors.stream()
                .collect(Collectors.toMap(
                        ILoanStrategy::getCode,
                        Function.identity(),
                        (l, r) -> {throw new IllegalArgumentException("Duplicate keys " + l + "and " + r + ".");},
                        () -> new EnumMap<>(LoanType.class)
                ));
    }

    @Override
    public LoanProcessorRegistry.LoanProcessorType getCode() {
        return LoanProcessorRegistry.LoanProcessorType.ENUM_MAP;
    }

    public Boolean process(LoanRequest request) {
        ILoanStrategy processor = loanProcessors.get(request.getLoanType());
        Objects.requireNonNull(processor, "No processor for " + request.getLoanType() + " found");
        return processor.evaluate(request);
    }

}
