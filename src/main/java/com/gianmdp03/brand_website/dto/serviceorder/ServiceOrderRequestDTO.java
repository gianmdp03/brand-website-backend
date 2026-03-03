package com.gianmdp03.brand_website.dto.serviceorder;

import com.gianmdp03.brand_website.extra.servicedetail.ServiceDetail;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public record ServiceOrderRequestDTO(@NotNull Map<String, ServiceDetail> serviceDetail,
                                     @NotNull Long clientId,
                                     @NotNull @Positive BigDecimal price,
                                     @NotNull @FutureOrPresent LocalDate date) {
}
