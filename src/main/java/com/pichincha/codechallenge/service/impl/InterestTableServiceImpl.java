package com.pichincha.codechallenge.service.impl;

import com.pichincha.codechallenge.presenter.InterestTablePresenter;
import com.pichincha.codechallenge.service.InterestTableService;
import com.pichincha.codechallenge.utils.MaskUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InterestTableServiceImpl implements InterestTableService {
    @Override
    public List<InterestTablePresenter> generateInterestTable(Double yearlyFee, Double amount, Integer yearlyPayments, Integer years) {
        Double periodicFee = yearlyFee / yearlyPayments;
        int totalPayments = years * yearlyPayments;
        List<InterestTablePresenter> result = new ArrayList<>();
        Double balance = amount;
        result.add(InterestTablePresenter.builder()
                .pendingAmount(MaskUtils.maskAsMoney(balance))
                .build());
        Double capital = 0.0;
        for (int i = 1; i <= totalPayments; i++) {
            balance = balance - capital;
            capital = balance.compareTo(0.05) < 0 ? 0.0 : amount / totalPayments;
            Double periodFee = balance * periodicFee / 100;
            result.add(InterestTablePresenter.builder()
                    .paymentNumber(i)
                    .pendingAmount(MaskUtils.maskAsMoney(balance))
                    .periodFee(MaskUtils.maskAsMoney(periodFee))
                    .capital(MaskUtils.maskAsMoney(capital))
                    .amount(MaskUtils.maskAsMoney(periodFee + capital))
                    .build());
        }
        printAsTable(result);
        return result;
    }

    private void printAsTable(List<InterestTablePresenter> interestTablePresenters) {
        interestTablePresenters.forEach(interestTablePresenter -> {
            System.out.println((Objects.nonNull(interestTablePresenter.getPaymentNumber()) ? interestTablePresenter.getPaymentNumber() : "").toString().concat("\t").concat((Objects.nonNull(interestTablePresenter.getPeriodFee()) ? interestTablePresenter.getPeriodFee() : "")).concat("\t").concat((Objects.nonNull(interestTablePresenter.getCapital()) ? interestTablePresenter.getCapital() : "")).concat("\t").concat((Objects.nonNull(interestTablePresenter.getAmount()) ? interestTablePresenter.getAmount() : "")).concat("\t").concat(interestTablePresenter.getPendingAmount()));
        });
    }
}
