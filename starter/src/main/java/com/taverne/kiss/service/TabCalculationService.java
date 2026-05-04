package com.taverne.kiss.service;

import com.taverne.kiss.model.CalculationResult;
import com.taverne.kiss.model.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class TabCalculationService {

    public CalculationResult calculate(OrderRequest request) {
        double total = request.getItems().stream()
                .mapToDouble(item -> item.getPrice())
                .sum();

        boolean hasMeal = request.getItems().stream()
                .anyMatch(item -> "MEAL".equals(item.getType()));
        boolean hasDrink = request.getItems().stream()
                .anyMatch(item -> "DRINK".equals(item.getType()));

        if (hasMeal && hasDrink) {
            total = total * 0.90;
        }

        return new CalculationResult(total);
    }
}
