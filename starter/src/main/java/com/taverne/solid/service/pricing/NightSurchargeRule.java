package com.taverne.solid.service.pricing;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class NightSurchargeRule implements PricingRule {

    private static final double NIGHT_SURCHARGE_RATE = 0.10;

    @Override
    public double apply(double baseTotal) {
        if (LocalTime.now().getHour() >= 22) {
            return baseTotal * NIGHT_SURCHARGE_RATE;
        }
        return 0;
    }
}
