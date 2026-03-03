package com.gianmdp03.brand_website.security.user.controller;

import com.gianmdp03.brand_website.security.user.dto.authentication.AuthenticationRequestDTO;
import com.gianmdp03.brand_website.security.user.dto.authentication.AuthenticationResponseDTO;
import com.gianmdp03.brand_website.security.user.dto.user.UserDetailDTO;
import com.gianmdp03.brand_website.security.user.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<UserDetailDTO> authenticate(@RequestBody AuthenticationRequestDTO request) {
        AuthenticationResponseDTO authResponse = authenticationService.authenticate(request);
        ResponseCookie cookie = createAccessTokenCookie(authResponse.token());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(authResponse.dto());
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout() {
        ResponseCookie cookie = ResponseCookie.from("accessToken", "")
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(0)
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }

    private ResponseCookie createAccessTokenCookie(String token) {
        return ResponseCookie.from("accessToken", token)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(24 * 60 * 60)
                .sameSite("Strict")
                .build();
    }
}
