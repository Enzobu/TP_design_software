package com.taverne.solid.service.pricing;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class WeekendDiscountRule implements PricingRule {

    private static final double WEEKEND_DISCOUNT_RATE = 0.05;

    @Override
    public double apply(double baseTotal) {
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY) {
            return -(baseTotal * WEEKEND_DISCOUNT_RATE);
        }
        return 0;
    }
}
