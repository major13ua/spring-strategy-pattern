package com.example.strategy.service;

import com.example.strategy.model.LoanRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanProcessorRegistry {

    public enum LoanProcessorType {
        CASE("case"), MAP("map"), ENUM_MAP("enum");
        public final String urlName;
        LoanProcessorType(String urlName) {
            this.urlName = urlName;
        }
        public static Optional<LoanProcessorType> byUrlCode(String urlCode) {
            return Arrays.stream(values())
                    .filter(type -> type.urlName.equals(urlCode))
                    .findFirst();
        }
    }

    private Map<LoanProcessorType, ILoanProcessor> processors = new EnumMap<>(LoanProcessorType.class);

    public void register(LoanProcessorType key, ILoanProcessor value) {
        processors.put(key, value);
    }

    public Optional<Boolean> evaluate(String processorType, LoanRequest loanRequest) {
        return LoanProcessorType
                .byUrlCode(processorType)
                .flatMap(type -> Optional.ofNullable(processors.get(type)))
                .map(processor -> processor.process(loanRequest));
    }

}
