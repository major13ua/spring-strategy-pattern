package com.example.strategy.service.approach4;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import com.example.strategy.service.LoanProcessorRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class GenericLoanProcessor extends AbstractStrategyProcessor<LoanType, IStrategy<LoanType>> {

    public GenericLoanProcessor(List<IStrategy<LoanType>> processors) {
        super(processors, LoanType.class);
    }

    @Override
    public LoanProcessorRegistry.LoanProcessorType getCode() {
        return LoanProcessorRegistry.LoanProcessorType.GENERIC_ENUM_MAP;
    }

    public Boolean process(LoanRequest request) {
        IStrategy processor = getProcessors().get(request.getLoanType());
        Objects.requireNonNull(processor, "No processor for " + request.getLoanType() + " found");
        return processor.evaluate(request);
    }

}
