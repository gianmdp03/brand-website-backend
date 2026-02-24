package com.gianmdp03.brand_website.dto.post;

import jakarta.validation.constraints.NotBlank;

public record PostRequestDTO(@NotBlank String name,
                             @NotBlank String description) {
}
