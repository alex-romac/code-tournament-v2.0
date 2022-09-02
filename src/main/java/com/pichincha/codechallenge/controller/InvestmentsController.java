package com.pichincha.codechallenge.controller;

import com.pichincha.codechallenge.presenter.InvestmentSimulationPresenter;
import com.pichincha.codechallenge.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class InvestmentsController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping("/simmulation")
    public List<InvestmentSimulationPresenter> generateSimulation(@RequestParam BigDecimal amount, @RequestParam Integer daysDuration) {
        //TODO logging
        return investmentService.getSimulation(amount, daysDuration);
    }
}
