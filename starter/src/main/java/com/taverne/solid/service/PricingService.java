package com.taverne.solid.service;

import com.taverne.solid.service.pricing.PricingRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    private final List<PricingRule> pricingRules;

    public PricingService(List<PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
    }

    public double calculateTotal(double unitPrice, int qty) {
        double baseTotal = unitPrice * qty;
        double adjustments = 0;

        for (PricingRule rule : pricingRules) {
            adjustments += rule.apply(baseTotal);
        }

        return baseTotal + adjustments;
    }
}
