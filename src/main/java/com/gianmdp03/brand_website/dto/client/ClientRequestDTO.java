package com.gianmdp03.brand_website.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDTO(@NotBlank String name,
                               @NotBlank String lastname,
                               @NotBlank @Email String email){}
