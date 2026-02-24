package com.gianmdp03.brand_website.dto.serviceorder;

import com.gianmdp03.brand_website.dto.client.ClientDetailDTO;
import com.gianmdp03.brand_website.model.servicedetail.ServiceDetail;

import java.math.BigDecimal;
import java.util.Map;

public record ServiceOrderDetailDTO(Long id, Map<String, ServiceDetail> serviceDetail, ClientDetailDTO client, BigDecimal price) {
}
