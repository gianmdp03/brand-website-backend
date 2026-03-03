package com.gianmdp03.brand_website.controller;

import com.gianmdp03.brand_website.dto.client.ClientDetailDTO;
import com.gianmdp03.brand_website.dto.client.ClientRequestDTO;
import com.gianmdp03.brand_website.dto.client.ClientUpdateDTO;
import com.gianmdp03.brand_website.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientDetailDTO> addClient(@Valid @RequestBody ClientRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addClient(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDetailDTO> getClientById(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getClientById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ClientDetailDTO>> listClients(@PageableDefault(page = 0, size = 10, sort = {"name", "lastname"})
                                                                 Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.listClients(pageable));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDetailDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientUpdateDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateClient(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        service.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
