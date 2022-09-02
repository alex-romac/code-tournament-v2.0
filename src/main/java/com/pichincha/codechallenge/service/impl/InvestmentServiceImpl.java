package com.pichincha.codechallenge.service.impl;

import com.pichincha.codechallenge.presenter.InterestDistributionPresenter;
import com.pichincha.codechallenge.presenter.InvestmentSimulationPresenter;
import com.pichincha.codechallenge.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class InvestmentServiceImpl implements InvestmentService {
    @Autowired
    private List<InterestDistributionPresenter> interestDistributionPresenters;

    @Override
    public List<InvestmentSimulationPresenter> getSimulation(BigDecimal amount, Integer daysDuration) {
        validateInputs(amount, daysDuration);
        List<InvestmentSimulationPresenter> result = new ArrayList<>();
        if (Objects.isNull(daysDuration)) {
            for (InterestDistributionPresenter interestDistributionPresenter : interestDistributionPresenters) {
                result.add(generateSingleSimmulation(amount, interestDistributionPresenter));
            }
            return result;
        }
        InterestDistributionPresenter requestedDistribution = findDistributionByDay(daysDuration, interestDistributionPresenters);
        return Collections.singletonList(generateSingleSimmulation(amount, requestedDistribution));
    }

    private InterestDistributionPresenter findDistributionByDay(Integer daysDuration, List<InterestDistributionPresenter> interestDistributionPresenters) {
        for (InterestDistributionPresenter interestDistributionPresenter : interestDistributionPresenters) {
            if (interestDistributionPresenter.getStartDuration().compareTo(daysDuration) <= 0 && interestDistributionPresenter.getEndDuration().compareTo(daysDuration) >= 0) {
                return interestDistributionPresenter;
            }
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "El plazo máximo permitido es 360 días");
    }

    private InvestmentSimulationPresenter generateSingleSimmulation(BigDecimal amount, InterestDistributionPresenter interestDistributionPresenter) {

        return null;
    }

    private void validateInputs(BigDecimal amount, Integer daysDuration) {
        if (Objects.isNull(amount)) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Se requiere un monto positivo para su inversión");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Se requiere un monto positivo para su inversión");
        }

        if (daysDuration.compareTo(0) <= 0) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Se requiere un plazo positivo para su inversión");
        }
    }
}
