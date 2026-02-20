package com.gianmdp03.brand_website.controller;

import com.gianmdp03.brand_website.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
}
