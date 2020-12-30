package com.example.strategy.service.approach4;

import com.example.strategy.service.ILoanProcessor;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractStrategyProcessor <K extends Enum<K>, V extends IStrategy<K>> implements ILoanProcessor {

    private final Map<K, V> processors;

    public AbstractStrategyProcessor(List<V> processors, Class<K> keyClass) {
        this.processors = processors.stream()
                .collect(Collectors.toMap(
                        V::getCode,
                        Function.identity(),
                        (l, r) -> {throw new IllegalArgumentException("Duplicate keys " + l + "and " + r + ".");},
                        () -> new EnumMap<>(keyClass)
                ));
    }

    protected final Map<K,V> getProcessors() {
        return processors;
    }

}
