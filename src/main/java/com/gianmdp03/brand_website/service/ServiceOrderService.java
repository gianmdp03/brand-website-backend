package com.gianmdp03.brand_website.service;

import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderDetailDTO;
import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderRequestDTO;
import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderStatusDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceOrderService {
    ServiceOrderDetailDTO addServiceOrder(ServiceOrderRequestDTO dto);
    ServiceOrderDetailDTO getServiceOrderById(Long id);
    Page<ServiceOrderDetailDTO> listServiceOrders(Pageable pageable);
    ServiceOrderDetailDTO updateServiceOrder(Long id, ServiceOrderRequestDTO dto);
    ServiceOrderDetailDTO modifyStatus(Long id, ServiceOrderStatusDTO dto);
    void deleteServiceOrder(Long id);
}
