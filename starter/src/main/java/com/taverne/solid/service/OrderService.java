package com.taverne.solid.service;

import com.taverne.solid.model.OrderRequest;
import com.taverne.solid.repository.INotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<OrderRequest> orders = new ArrayList<>();
    private final InventoryService inventoryService;
    private final PricingService pricingService;
    private final INotificationRepository notificationRepository;

    public OrderService(
            InventoryService inventoryService,
            PricingService pricingService,
            INotificationRepository notificationRepository
    ) {
        this.inventoryService = inventoryService;
        this.pricingService = pricingService;
        this.notificationRepository = notificationRepository;
    }

    public String processOrder(OrderRequest request) {
        String item = request.getItem();
        int qty = request.getQty();

        if (!inventoryService.hasStock(item, qty)) {
            return "Stock insuffisant";
        }

        inventoryService.decrement(item, qty);
        double total = pricingService.calculateTotal(request.getPrice(), qty);

        notificationRepository.save("Order: " + item + " x" + qty);
        orders.add(request);

        return "Total = " + total + " po";
    }
}
