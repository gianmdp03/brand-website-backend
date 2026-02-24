package com.gianmdp03.brand_website.service.impl;

import com.gianmdp03.brand_website.dto.post.PostDetailDTO;
import com.gianmdp03.brand_website.dto.post.PostRequestDTO;
import com.gianmdp03.brand_website.exception.NotFoundException;
import com.gianmdp03.brand_website.mapper.PostMapper;
import com.gianmdp03.brand_website.model.Post;
import com.gianmdp03.brand_website.repository.PostRepository;
import com.gianmdp03.brand_website.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final PostMapper mapper;

    @Override
    @Transactional
    public PostDetailDTO addPost(PostRequestDTO dto) {
        Post post = mapper.toEntity(dto);
        return mapper.toDetailDto(repository.save(post));
    }

    @Override
    public PostDetailDTO getPostById(Long id) {
        Post post = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Post ID does not exist"));
        return mapper.toDetailDto(post);
    }

    @Override
    public Page<PostDetailDTO> listPosts(Pageable pageable) {
        Page<Post> page = repository.findAll(pageable);
        if(page.isEmpty()){
            return Page.empty();
        }
        return page.map(mapper::toDetailDto);
    }

    @Override
    @Transactional
    public PostDetailDTO updatePost(Long id, PostRequestDTO dto) {
        Post post = repository.findById(id).orElseThrow(()-> new NotFoundException("Post ID does not exist"));
        mapper.updateEntityFromDto(dto, post);
        return mapper.toDetailDto(repository.save(post));
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        Post post = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Post ID does not exist"));
        repository.delete(post);
    }
}
