package com.gianmdp03.brand_website.dto.client;

import jakarta.validation.constraints.Email;

public record ClientUpdateDTO(String name, String lastname, @Email String email) {
}
