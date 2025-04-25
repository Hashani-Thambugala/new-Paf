package com.example.likeandcommentmanagement.controller;

import com.example.likeandcommentmanagement.model.*;
import com.example.likeandcommentmanagement.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/{postId}/like")
    public Post likePost(@PathVariable String postId) {
        return postService.likePost(postId);
    }

    @PostMapping("/{postId}/comments")
    public Comment addComment(@PathVariable String postId, @RequestBody Comment comment) {
        return postService.addComment(postId, comment);
    }

    @GetMapping("/{postId}/comments")
    public List<Comment> getComments(@PathVariable String postId) {
        return postService.getComments(postId);
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable String postId, @PathVariable String commentId, @RequestBody Comment comment) {
        return postService.updateComment(postId, commentId, comment);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable String postId, @PathVariable String commentId) {
        postService.deleteComment(postId, commentId);
    }
}