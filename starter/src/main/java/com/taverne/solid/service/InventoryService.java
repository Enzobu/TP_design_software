package com.taverne.solid.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {

    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("ALE", 100);
        stock.put("BREAD", 50);
        stock.put("STEW", 30);
    }

    public boolean hasStock(String item, int qty) {
        return stock.containsKey(item) && stock.get(item) >= qty;
    }

    public void decrement(String item, int qty) {
        stock.put(item, stock.get(item) - qty);
    }
}
