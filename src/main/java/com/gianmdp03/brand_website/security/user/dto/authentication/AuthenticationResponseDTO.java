package com.gianmdp03.brand_website.security.user.dto.authentication;

import com.gianmdp03.brand_website.security.user.dto.user.UserDetailDTO;

public record AuthenticationResponseDTO(String token, UserDetailDTO dto) {
}
