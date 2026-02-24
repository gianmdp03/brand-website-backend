package com.gianmdp03.brand_website.dto.serviceorder;

import com.gianmdp03.brand_website.extra._enum.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record ServiceOrderStatusDTO(@NotNull OrderStatus orderStatus) {
}
