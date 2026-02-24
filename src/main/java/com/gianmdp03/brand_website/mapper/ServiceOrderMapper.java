package com.gianmdp03.brand_website.mapper;

import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderDetailDTO;
import com.gianmdp03.brand_website.dto.serviceorder.ServiceOrderRequestDTO;
import com.gianmdp03.brand_website.model.ServiceOrder;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = ClientMapper.class)
public abstract class ServiceOrderMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    public abstract ServiceOrder toEntity(ServiceOrderRequestDTO dto);
    public abstract ServiceOrderDetailDTO toDetailDto(ServiceOrder entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    public abstract void updateEntityFromDto(ServiceOrderRequestDTO dto, @MappingTarget ServiceOrder entity);

}
