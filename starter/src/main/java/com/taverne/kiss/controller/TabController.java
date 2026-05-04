package com.taverne.kiss.controller;

import com.taverne.kiss.model.CalculationResult;
import com.taverne.kiss.model.OrderRequest;
import com.taverne.kiss.service.TabCalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tab")
public class TabController {

    private final TabCalculationService tabCalculationService;

    public TabController(TabCalculationService tabCalculationService) {
        this.tabCalculationService = tabCalculationService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculationResult> calculate(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(tabCalculationService.calculate(request));
    }
}
