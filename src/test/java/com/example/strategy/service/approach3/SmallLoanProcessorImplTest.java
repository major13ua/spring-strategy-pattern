package com.example.strategy.service.approach3;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class SmallLoanProcessorImplTest {

    @Test
    void shouldSupportOnlySmallLoans() {
        SmallLoanStrategyImpl smallLoanProcessor = new SmallLoanStrategyImpl();
        assertThat(smallLoanProcessor.getCode()).isEqualTo(LoanType.SMALL);
    }

    @Test
    void shouldProcessSmallLoan() {
        SmallLoanStrategyImpl smallLoanProcessor = spy(new SmallLoanStrategyImpl());
        LoanRequest loanRequest = LoanRequest.builder().loanType(LoanType.SMALL).build();
        Boolean process = smallLoanProcessor.evaluate(loanRequest);
        assertThat(process).isTrue();
        verify(smallLoanProcessor, times(1)).getCode();
    }

    @Test
    void shouldThrowErrorIfLoanTypeIsNotSmall() {
        SmallLoanStrategyImpl smallLoanProcessor = spy(new SmallLoanStrategyImpl());
        LoanRequest loanRequest = LoanRequest.builder().loanType(LoanType.BIG).build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            smallLoanProcessor.evaluate(loanRequest);
        });
    }

}
