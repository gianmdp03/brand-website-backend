package com.gianmdp03.brand_website.dto.serviceorder;

import com.gianmdp03.brand_website.extra.servicedetail.ServiceDetail;

import java.math.BigDecimal;
import java.util.Map;

public record ServiceOrderUpdateDTO(Map<String, ServiceDetail> serviceDetails, Long clientId, BigDecimal price) {}
