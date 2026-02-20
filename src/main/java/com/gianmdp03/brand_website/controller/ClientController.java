package com.gianmdp03.brand_website.controller;

import com.gianmdp03.brand_website.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
}
