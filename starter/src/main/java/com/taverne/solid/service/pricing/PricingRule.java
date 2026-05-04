package com.taverne.solid.service.pricing;

public interface PricingRule {
    double apply(double baseTotal);
}
