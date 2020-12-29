package com.example.strategy.controller;


import com.example.strategy.model.LoanRequest;
import com.example.strategy.service.approach1.CaseStrategyImpl;
import com.example.strategy.service.approach2.MapStrategyImpl;
import com.example.strategy.service.approach3.EnumMapStrategyImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final CaseStrategyImpl approach1;
    private final MapStrategyImpl approach2;
    private final EnumMapStrategyImpl approach3;

    @PostMapping("/approach1")
    public ResponseEntity<Boolean> approach1(@RequestBody @Valid LoanRequest loanRequest) {
        return ResponseEntity.ok(approach1.process(loanRequest));
    }

    @PostMapping("/approach2")
    public ResponseEntity<Boolean> approach2(@RequestBody @Valid LoanRequest loanRequest) {
        return ResponseEntity.ok(approach2.process(loanRequest));
    }

    @PostMapping("/approach3")
    public ResponseEntity<Boolean> approach3(@RequestBody @Valid LoanRequest loanRequest) {
        return ResponseEntity.ok(approach3.process(loanRequest));
    }

}
