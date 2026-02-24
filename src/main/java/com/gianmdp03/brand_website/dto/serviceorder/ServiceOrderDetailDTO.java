package com.gianmdp03.brand_website.dto.serviceorder;

import com.gianmdp03.brand_website.dto.client.ClientDetailDTO;
import com.gianmdp03.brand_website.extra._enum.OrderStatus;
import com.gianmdp03.brand_website.extra.servicedetail.ServiceDetail;

import java.math.BigDecimal;
import java.util.Map;

public record ServiceOrderDetailDTO(Long id, OrderStatus orderStatus, Map<String, ServiceDetail> serviceDetail, ClientDetailDTO client, BigDecimal price) {
}
