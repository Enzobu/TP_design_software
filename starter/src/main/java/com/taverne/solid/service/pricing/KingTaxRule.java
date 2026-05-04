package com.taverne.solid.service.pricing;

import org.springframework.stereotype.Component;

@Component
public class KingTaxRule implements PricingRule {

    private static final double KING_TAX_RATE = 0.05;

    @Override
    public double apply(double baseTotal) {
        return baseTotal * KING_TAX_RATE;
    }
}
