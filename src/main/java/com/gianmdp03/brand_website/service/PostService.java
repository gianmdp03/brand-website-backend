package com.gianmdp03.brand_website.service;

import com.gianmdp03.brand_website.dto.post.PostDetailDTO;
import com.gianmdp03.brand_website.dto.post.PostRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDetailDTO addPost(PostRequestDTO dto);
    PostDetailDTO getPostById(Long id);
    Page<PostDetailDTO> listPosts(Pageable pageable);
    PostDetailDTO updatePost(Long id, PostRequestDTO dto);
    void deletePost(Long id);
}
