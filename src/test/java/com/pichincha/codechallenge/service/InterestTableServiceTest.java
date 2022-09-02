package com.pichincha.codechallenge.service;

import com.pichincha.codechallenge.presenter.InterestTablePresenter;
import com.pichincha.codechallenge.service.impl.InterestTableServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class InterestTableServiceTest {
    @InjectMocks
    private InterestTableService interestTableService = new InterestTableServiceImpl();

    @Test
    public void shouldReturnInterestTable() {
        int years = 1;
        int payments = 12;
        List<InterestTablePresenter> interestTablePresenters = interestTableService.generateInterestTable(12.0, 85000.0, payments, years);
        Assertions.assertEquals((years * payments) + 1, interestTablePresenters.size());
    }
}
