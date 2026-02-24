package com.gianmdp03.brand_website.controller;

import com.gianmdp03.brand_website.dto.client.ClientDetailDTO;
import com.gianmdp03.brand_website.dto.client.ClientRequestDTO;
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
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDetailDTO> addClient(@Valid @RequestBody ClientRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDetailDTO> getClientById(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ClientDetailDTO>> listClients(@PageableDefault(page = 0, size = 10, sort = {"name", "lastname"})
                                                                 Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.listClients(pageable));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDetailDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientRequestDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
