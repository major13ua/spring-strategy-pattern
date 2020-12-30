package com.example.strategy.controller;

import com.example.strategy.model.LoanRequest;
import com.example.strategy.service.LoanProcessorRegistry;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanProcessorRegistry loanProcessorRegistry;

    @PostMapping("/{type}/")
    public ResponseEntity<Boolean> approach1(@PathVariable String type, @RequestBody @Valid LoanRequest loanRequest) {
        return loanProcessorRegistry.evaluate(type, loanRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
