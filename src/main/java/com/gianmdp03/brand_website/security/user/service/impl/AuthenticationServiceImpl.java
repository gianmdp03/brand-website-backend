package com.gianmdp03.brand_website.security.user.service.impl;

import com.gianmdp03.brand_website.exception.NotFoundException;
import com.gianmdp03.brand_website.security.user.dto.authentication.AuthenticationRequestDTO;
import com.gianmdp03.brand_website.security.user.dto.authentication.AuthenticationResponseDTO;
import com.gianmdp03.brand_website.security.user.dto.user.UserDetailDTO;
import com.gianmdp03.brand_website.security.user.model.User;
import com.gianmdp03.brand_website.security.user.repository.UserRepository;
import com.gianmdp03.brand_website.security.user.service.AuthenticationService;
import com.gianmdp03.brand_website.security.user.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(()-> new NotFoundException("User Email does not exist"));
        String jwtToken = jwtService.generateToken(user);
        UserDetailDTO userDetail = new UserDetailDTO(
                user.getId(),
                user.getEmail()
        );

        return new AuthenticationResponseDTO(jwtToken, userDetail);
    }


}
