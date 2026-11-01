package com.example.inventoryservice;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @GetMapping
    public List<Map<String, Object>> inventory() {
        return List.of(
            Map.of("sku", "LAP-001", "item", "Laptop", "available", 12),
            Map.of("sku", "KEY-001", "item", "Keyboard", "available", 45),
            Map.of("sku", "MOU-001", "item", "Mouse", "available", 80)
        );
    }
}
