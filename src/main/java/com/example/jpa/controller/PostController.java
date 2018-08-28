package com.example.jpa.controller;

import com.example.jpa.model.Post;
import com.example.jpa.model.Tag;
import com.example.jpa.repository.PostRepository;
import com.example.jpa.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;

    @GetMapping("/posts")
    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @GetMapping("/tags")
    public Page<Tag> getAllTags(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @GetMapping("/posts/{id}")
    public Page<Post> getPost(@PathVariable (value = "id") Long id, Pageable pageable) {
        return postRepository.findById(id, pageable);
    }

    @GetMapping("/tags/{id}")
    public Page<Tag> getTag(@PathVariable (value = "id") Long id, Pageable pageable) {
        return tagRepository.findById(id, pageable);
    }

    @GetMapping("/tagname")
    public  List<Tag> getName(@RequestParam("name") String name) {
        return tagRepository.findByName(name);
    }

    /*
    @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
    */
}
