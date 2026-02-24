package com.gianmdp03.brand_website.mapper;

import com.gianmdp03.brand_website.dto.post.PostDetailDTO;
import com.gianmdp03.brand_website.dto.post.PostRequestDTO;
import com.gianmdp03.brand_website.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
    @Mapping(target = "id", ignore = true)
    public abstract Post toEntity(PostRequestDTO dto);
    public abstract PostDetailDTO toDetailDto(Post entity);
}
