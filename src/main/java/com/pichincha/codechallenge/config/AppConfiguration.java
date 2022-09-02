package com.pichincha.codechallenge.config;

import com.pichincha.codechallenge.presenter.InterestDistributionPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfiguration {
    @Bean
    public List<InterestDistributionPresenter> interestDistributions() {
        return Arrays.asList(
                InterestDistributionPresenter.builder()
                        .startDuration(1)
                        .endDuration(30)
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(31)
                        .endDuration(60)
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(61)
                        .endDuration(90)
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(91)
                        .endDuration(120)
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(121)
                        .endDuration(180)
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(181)
                        .endDuration(240)
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(241)
                        .endDuration(300)
                        .build(),
                InterestDistributionPresenter.builder()
                        .startDuration(301)
                        .endDuration(360)
                        .build()

        );
    }
}
