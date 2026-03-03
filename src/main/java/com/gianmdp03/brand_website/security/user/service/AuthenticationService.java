package com.gianmdp03.brand_website.security.user.service;

import com.gianmdp03.brand_website.security.user.dto.authentication.AuthenticationRequestDTO;
import com.gianmdp03.brand_website.security.user.dto.authentication.AuthenticationResponseDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
}
