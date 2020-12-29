package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SmallLoanProcessorImplTest {

    @Test
    void shouldCalculateSmallLoan() {
        SmallLoanProcessorImpl impl = new SmallLoanProcessorImpl();
        LoanRequest loan = new LoanRequest();
        loan.setLoanType(LoanType.SMALL);
        Boolean process = impl.process(loan);
        assertThat(process).isTrue();
    }

    @Test
    void shouldNotCalculateBigLoan() {
        SmallLoanProcessorImpl impl = new SmallLoanProcessorImpl();
        LoanRequest loan = new LoanRequest();
        loan.setLoanType(LoanType.BIG);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            impl.process(loan);
        });
    }

    @Test
    void shouldNotCalculateMediumLoan() {
        SmallLoanProcessorImpl impl = new SmallLoanProcessorImpl();
        LoanRequest loan = new LoanRequest();
        loan.setLoanType(LoanType.MEDIUM);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            impl.process(loan);
        });
    }

    @Test
    void shouldNotCalculateHugeLoan() {
        SmallLoanProcessorImpl impl = new SmallLoanProcessorImpl();
        LoanRequest loan = new LoanRequest();
        loan.setLoanType(LoanType.HUGE);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            impl.process(loan);
        });
    }

}
