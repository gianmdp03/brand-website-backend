package com.gianmdp03.brand_website.controller;

import com.gianmdp03.brand_website.service.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/service_orders")
@RequiredArgsConstructor
public class ServiceOrderController {
    private final ServiceOrderService serviceOrderService;
}
