package com.example.jpa.repository;

import com.example.jpa.model.Post;
import com.example.jpa.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findById(Long id, Pageable pageable);
    //List<Tag> findByTags(Long id, Pageable pageable);
}
