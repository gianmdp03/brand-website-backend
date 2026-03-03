package com.gianmdp03.brand_website.security.user.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequestDTO(@NotBlank @Email String email, @NotBlank String password) {
}
