package com.gianmdp03.brand_website.mapper;

import com.gianmdp03.brand_website.dto.client.ClientDetailDTO;
import com.gianmdp03.brand_website.dto.client.ClientRequestDTO;
import com.gianmdp03.brand_website.model.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    public abstract Client toEntity(ClientRequestDTO dto);
    public abstract ClientDetailDTO toDetailDto(Client entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    public abstract void updateEntityFromDto(ClientRequestDTO dto, @MappingTarget Client entity);
}
