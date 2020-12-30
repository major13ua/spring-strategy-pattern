package com.example.strategy.service.approach2;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.model.LoanType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class MapLoanProcessorTest {

    @Autowired
    public MapLoanProcessor mapStrategy;

    @MockBean
    public SmallLoanStrategyImpl smallLoanProcessor;
    @SpyBean
    public MediumLoanStrategyImpl mediumLoanProcessor;

    @Test
    void shouldCallSmallLoanProcessor() {
        LoanRequest request = LoanRequest.builder().loanType(LoanType.SMALL).build();
        given(smallLoanProcessor.process(any())).willReturn(Boolean.TRUE);
        Boolean process = mapStrategy.process(request);
        assertThat(process).isTrue();
        verify(smallLoanProcessor, times(1)).process(any());
    }

    @Test
    void shouldCallMediumLoanProcessor() {
        LoanRequest request = LoanRequest.builder().loanType(LoanType.MEDIUM).build();
        Boolean process = mapStrategy.process(request);
        assertThat(process).isTrue();
        verify(mediumLoanProcessor, times(1)).process(any());
    }

}
