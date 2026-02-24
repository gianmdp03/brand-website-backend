package com.gianmdp03.brand_website.service.impl;

import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderDetailDTO;
import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderRequestDTO;
import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderStatusDTO;
import com.gianmdp03.brand_website.exception.NotFoundException;
import com.gianmdp03.brand_website.mapper.ServiceOrderMapper;
import com.gianmdp03.brand_website.model.Client;
import com.gianmdp03.brand_website.model.ServiceOrder;
import com.gianmdp03.brand_website.repository.ClientRepository;
import com.gianmdp03.brand_website.repository.ServiceOrderRepository;
import com.gianmdp03.brand_website.service.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceOrderServiceImpl implements ServiceOrderService {
    private final ServiceOrderRepository repository;
    private final ServiceOrderMapper mapper;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public ServiceOrderDetailDTO addServiceOrder(ServiceOrderRequestDTO dto) {
        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(()-> new NotFoundException("Client ID does not exist"));
        ServiceOrder serviceOrder = mapper.toEntity(dto);
        serviceOrder.setClient(client);
        return mapper.toDetailDto(repository.save(serviceOrder));
    }

    @Override
    public ServiceOrderDetailDTO getServiceOrderById(Long id) {
        ServiceOrder serviceOrder = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Service Order ID does not exist"));
        return mapper.toDetailDto(serviceOrder);
    }

    @Override
    public Page<ServiceOrderDetailDTO> listServiceOrders(Pageable pageable) {
        Page<ServiceOrder> page = repository.findAll(pageable);
        if(page.isEmpty()){
            return Page.empty();
        }
        return page.map(mapper::toDetailDto);
    }

    @Override
    @Transactional
    public ServiceOrderDetailDTO updateServiceOrder(Long id, ServiceOrderRequestDTO dto) {
        ServiceOrder serviceOrder = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Service Order ID does not exist"));
        mapper.updateEntityFromDto(dto, serviceOrder);
        return mapper.toDetailDto(repository.save(serviceOrder));
    }

    @Override
    @Transactional
    public ServiceOrderDetailDTO modifyStatus(Long id, ServiceOrderStatusDTO dto){
        ServiceOrder serviceOrder = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Service Order ID does not exist"));
        serviceOrder.setOrderStatus(dto.orderStatus());
        return mapper.toDetailDto(repository.save(serviceOrder));
    }

    @Override
    @Transactional
    public void deleteServiceOrder(Long id) {
        ServiceOrder serviceOrder = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Service Order ID does not exist"));
        repository.delete(serviceOrder);
    }
}
