package com.pichincha.codechallenge.challenge;

import com.pichincha.codechallenge.presenter.InterestDistributionPresenter;
import com.pichincha.codechallenge.presenter.InvestmentSimulationPresenter;
import com.pichincha.codechallenge.service.InvestmentService;
import com.pichincha.codechallenge.service.impl.InvestmentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ChallengeTest {
    @InjectMocks
    private InvestmentService investmentService = new InvestmentServiceImpl();

    @Test
    public void challenge() {
        ReflectionTestUtils.setField(investmentService, "interestDistributionPresenters", testInterestTable());
        List<InvestmentSimulationPresenter> simulation = investmentService.getSimulation(new BigDecimal("30000"), null);
        Assertions.assertTrue(simulation.size() > 1);
    }

    @Test
    public void challengeWithDuration() {
        ReflectionTestUtils.setField(investmentService, "interestDistributionPresenters", testInterestTable());
        List<InvestmentSimulationPresenter> simulation = investmentService.getSimulation(new BigDecimal("30000"), 30);
        Assertions.assertEquals(1, simulation.size());
    }

    @Test
    public void challengeWithTable() {
        ReflectionTestUtils.setField(investmentService, "interestDistributionPresenters", testInterestTable());
        List<InvestmentSimulationPresenter> simulation = investmentService.getSimulation(new BigDecimal("30000"), null);
        System.out.println("Plazo en días\tTasa de interés anual\tInterés ganado en USD\tTotal a recibir monto más interes USD\n");
        simulation.forEach(investmentSimulationPresenter -> {
            System.out.println(String.valueOf(investmentSimulationPresenter.getDuration()).concat("\t").concat(investmentSimulationPresenter.getFee().concat("\t").concat(investmentSimulationPresenter.getProfit()).concat("\t").concat(investmentSimulationPresenter.getGrandTotal()).concat("\n")));
        });
        Assertions.assertTrue(simulation.size() > 1);
    }

    private List<InterestDistributionPresenter> testInterestTable() {
        return Arrays.asList(
                InterestDistributionPresenter.builder()
                        .startDuration(1)
                        .endDuration(30)
                        .fee(new BigDecimal("2"))
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(31)
                        .endDuration(60)
                        .fee(new BigDecimal("2.20"))
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(61)
                        .endDuration(90)
                        .fee(new BigDecimal("2.40"))
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(91)
                        .endDuration(120)
                        .fee(new BigDecimal("2.60"))
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(121)
                        .endDuration(180)
                        .fee(new BigDecimal("2.80"))
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(181)
                        .endDuration(240)
                        .fee(new BigDecimal("3"))
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(241)
                        .endDuration(300)
                        .fee(new BigDecimal("3.20"))
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(301)
                        .endDuration(360)
                        .fee(new BigDecimal("3.40"))
                        .build()

        );
    }
}
