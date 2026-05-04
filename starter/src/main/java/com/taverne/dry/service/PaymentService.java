package com.taverne.dry.service;

import com.taverne.dry.model.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final double KING_TAX_RATE = 0.05;
    private static final double WARRIOR_SURCHARGE = 2.0;

    private double calculateTax(double base) {
        return base * KING_TAX_RATE;
    }

    private double calculateBase(PaymentRequest req) {
        return req.getPrice() * req.getQuantity();
    }

    private void validate(PaymentRequest req) {
        if (req.getPrice() < 0) {
            throw new IllegalArgumentException("price must be >= 0");
        }
        if (req.getQuantity() <= 0) {
            throw new IllegalArgumentException("quantity must be > 0");
        }
    }

    public double calculateWarrior(PaymentRequest req) {
        validate(req);
        double base = calculateBase(req);
        double kingTax = calculateTax(base);

        return base + kingTax + WARRIOR_SURCHARGE;
    }

    public double calculateMage(PaymentRequest req) {
        validate(req);
        return calculateBase(req);
    }

    public double calculateRogue(PaymentRequest req) {
        validate(req);
        double base = calculateBase(req);
        double kingTax = calculateTax(base);

        return base + kingTax;
    }
}
