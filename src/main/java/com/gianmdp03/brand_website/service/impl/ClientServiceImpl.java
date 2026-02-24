package com.gianmdp03.brand_website.service.impl;

import com.gianmdp03.brand_website.dto.client.ClientDetailDTO;
import com.gianmdp03.brand_website.dto.client.ClientRequestDTO;
import com.gianmdp03.brand_website.exception.NotFoundException;
import com.gianmdp03.brand_website.mapper.ClientMapper;
import com.gianmdp03.brand_website.model.Client;
import com.gianmdp03.brand_website.repository.ClientRepository;
import com.gianmdp03.brand_website.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Override
    @Transactional
    public ClientDetailDTO addClient(ClientRequestDTO dto) {
        Optional<Client> existingClient = repository.findByEmail(dto.email());
        if(existingClient.isPresent()){
            Client client = existingClient.get();
            if(client.isDeleted()){
                client.setDeleted(false);
                return mapper.toDetailDto(repository.save(client));
            }
            else
            {
                throw new IllegalArgumentException("Client already exists");
            }
        }
        Client client = mapper.toEntity(dto);
        client.setDeleted(false);
        return mapper.toDetailDto(repository.save(client));
    }

    @Override
    public ClientDetailDTO getClientById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Client ID does not exist"));
        return mapper.toDetailDto(client);
    }

    @Override
    public Page<ClientDetailDTO> listClients(Pageable pageable) {
        Page<Client> page = repository.findAll(pageable);
        if(page.isEmpty()){
            return Page.empty();
        }
        return page.map(mapper::toDetailDto);
    }

    @Override
    @Transactional
    public ClientDetailDTO updateClient(Long id, ClientRequestDTO dto) {
        Client client = repository.findById(id).orElseThrow(()-> new NotFoundException("Client ID does not exist"));
        mapper.updateEntityFromDto(dto, client);
        return mapper.toDetailDto(repository.save(client));
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        Client client = repository.findById(id).orElseThrow(()-> new NotFoundException("Client ID does not exist"));
        client.setDeleted(true);
        repository.save(client);
    }
}
