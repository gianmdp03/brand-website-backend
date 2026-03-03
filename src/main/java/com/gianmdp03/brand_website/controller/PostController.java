package com.gianmdp03.brand_website.controller;

import com.gianmdp03.brand_website.dto.post.PostDetailDTO;
import com.gianmdp03.brand_website.dto.post.PostRequestDTO;
import com.gianmdp03.brand_website.dto.post.PostUpdateDTO;
import com.gianmdp03.brand_website.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @PostMapping
    public ResponseEntity<PostDetailDTO> addPost(@Valid @RequestBody PostRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addPost(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailDTO> getPostById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getPostById(id));
    }

    @GetMapping
    public ResponseEntity<Page<PostDetailDTO>> listPosts(@PageableDefault(page = 0, size = 10, sort = {"name"})
                                                             Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.listPosts(pageable));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostDetailDTO> updatePost(@PathVariable Long id, @Valid @RequestBody PostUpdateDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePost(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        service.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
