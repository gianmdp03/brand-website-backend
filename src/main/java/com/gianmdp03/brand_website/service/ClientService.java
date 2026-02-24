package com.gianmdp03.brand_website.service;

import com.gianmdp03.brand_website.dto.client.ClientDetailDTO;
import com.gianmdp03.brand_website.dto.client.ClientRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    ClientDetailDTO addClient(ClientRequestDTO dto);
    ClientDetailDTO getClientById(Long id);
    Page<ClientDetailDTO> listClients(Pageable pageable);
    ClientDetailDTO updateClient(Long id, ClientRequestDTO dto);
    void deleteClient(Long id);
}
