package com.gianmdp03.brand_website.controller;

import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderDetailDTO;
import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderRequestDTO;
import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderStatusDTO;
import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderUpdateDTO;
import com.gianmdp03.brand_website.service.ServiceOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service_orders")
@RequiredArgsConstructor
public class ServiceOrderController {
    private final ServiceOrderService service;

    @PostMapping
    public ResponseEntity<ServiceOrderDetailDTO> addServiceOrder(@Valid @RequestBody ServiceOrderRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addServiceOrder(dto));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderDetailDTO> getServiceOrderById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getServiceOrderById(id));
    }
    
    @GetMapping
    public ResponseEntity<Page<ServiceOrderDetailDTO>> listServiceOrders(
            @PageableDefault(page = 0, size = 10) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.listServiceOrders(pageable));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<ServiceOrderDetailDTO> updateServiceOrder(@PathVariable Long id, @Valid @RequestBody ServiceOrderUpdateDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateServiceOrder(id, dto));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ServiceOrderDetailDTO> modifyStatus(@PathVariable Long id, @Valid @RequestBody ServiceOrderStatusDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.modifyStatus(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceOrder(@PathVariable Long id){
        service.deleteServiceOrder(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
