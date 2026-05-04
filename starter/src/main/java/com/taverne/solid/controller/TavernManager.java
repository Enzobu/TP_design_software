package com.taverne.solid.controller;

import com.taverne.solid.model.ConsumableItem;
import com.taverne.solid.model.OrderRequest;
import com.taverne.solid.model.PoisonousDrink;
import com.taverne.solid.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TavernManager {

    private final OrderService orderService;

    public TavernManager(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/order")
    public String processOrder(@RequestBody OrderRequest request) {
        return orderService.processOrder(request);
    }

    @GetMapping("/api/consume-check")
    public String consumeCheck() {
        List<ConsumableItem> menu = new ArrayList<>();
        menu.add(new ConsumableItem());
        menu.add(new PoisonousDrink());

        StringBuilder result = new StringBuilder();
        for (ConsumableItem it : menu) {
            result.append(it.isSafeToConsume() ? "safe" : "danger").append("\n");
        }
        return result.toString();
    }
}
