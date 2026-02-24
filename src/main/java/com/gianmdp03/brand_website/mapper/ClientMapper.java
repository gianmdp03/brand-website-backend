package com.gianmdp03.brand_website.mapper;

import com.gianmdp03.brand_website.dto.client.ClientDetailDTO;
import com.gianmdp03.brand_website.dto.client.ClientRequestDTO;
import com.gianmdp03.brand_website.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    @Mapping(target = "id", ignore = true)
    public abstract Client toEntity(ClientRequestDTO dto);
    public abstract ClientDetailDTO toDetailDto(Client entity);
}
