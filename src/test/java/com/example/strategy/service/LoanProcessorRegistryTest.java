package com.example.strategy.service;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class LoanProcessorRegistryTest {

    @Autowired
    LoanProcessorRegistry loanProcessorRegistry;

    @Test
    void shouldReturnEmptyIfNoProcessorFound() {

        Optional<Boolean> undefinedStrategy = loanProcessorRegistry.evaluate("undefinedStrategy",
                LoanRequest.builder().loanType(LoanType.SMALL).build());

        assertThat(undefinedStrategy).isEmpty();

    }

    @Test
    void shouldCallGenericLoanProcessorForSmallLoan() {

        Optional<Boolean> genericProcessorWithSmallStrategy = loanProcessorRegistry.evaluate("generic",
                LoanRequest.builder().loanType(LoanType.SMALL).build());

        assertThat(genericProcessorWithSmallStrategy).isPresent();
        assertThat(genericProcessorWithSmallStrategy).hasValueSatisfying(value -> assertThat(value).isTrue());

    }

}
