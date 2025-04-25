package com.example.likeandcommentmanagement.service;

import com.example.likeandcommentmanagement.model.*;
import com.example.likeandcommentmanagement.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public Post likePost(String postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        post.setLikes(post.getLikes() + 1);
        return postRepository.save(post);
    }

    public Comment addComment(String postId, Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow();
        comment.setId(UUID.randomUUID().toString());
        post.getComments().add(comment);
        postRepository.save(post);
        return comment;
    }

    public List<Comment> getComments(String postId) {
        return postRepository.findById(postId).orElseThrow().getComments();
    }

    public Comment updateComment(String postId, String commentId, Comment updatedComment) {
        Post post = postRepository.findById(postId).orElseThrow();
        List<Comment> comments = post.getComments();
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId().equals(commentId)) {
                updatedComment.setId(commentId);
                comments.set(i, updatedComment);
                postRepository.save(post);
                return updatedComment;
            }
        }
        throw new RuntimeException("Comment not found");
    }

    public void deleteComment(String postId, String commentId) {
        Post post = postRepository.findById(postId).orElseThrow();
        post.getComments().removeIf(comment -> comment.getId().equals(commentId));
        postRepository.save(post);
    }
}