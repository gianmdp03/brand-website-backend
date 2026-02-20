package com.gianmdp03.brand_website.repository;

import com.gianmdp03.brand_website.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
