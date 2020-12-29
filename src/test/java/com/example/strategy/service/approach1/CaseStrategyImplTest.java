package com.example.strategy.service.approach1;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CaseStrategyImplTest {

    @Test
    void shouldCallSmallStrategyImplForSmallCredit() {
        CaseStrategyImpl caseStrategy = new CaseStrategyImpl();
        CaseStrategyImpl spy = Mockito.spy(caseStrategy);

        LoanRequest loan = new LoanRequest();
        loan.setLoanType(LoanType.SMALL);

        Boolean process = spy.process(loan);
        assertThat(process).isTrue();

        verify(spy, times(1)).smallCredit(any());
        verify(spy, times(0)).bigCredit(any());
        verify(spy, times(0)).hugeCredit(any());
        verify(spy, times(0)).mediumCredit(any());
    }


    @Test
    void shouldCallMediumStrategyImplForMediumCredit() {
        CaseStrategyImpl caseStrategy = new CaseStrategyImpl();
        CaseStrategyImpl spy = Mockito.spy(caseStrategy);

        LoanRequest loan = new LoanRequest();
        loan.setLoanType(LoanType.MEDIUM);

        Boolean process = spy.process(loan);
        assertThat(process).isTrue();

        verify(spy, times(0)).smallCredit(any());
        verify(spy, times(0)).bigCredit(any());
        verify(spy, times(0)).hugeCredit(any());
        verify(spy, times(1)).mediumCredit(any());
    }

}
