package com.example.likeandcommentmanagement.repository;

import com.example.likeandcommentmanagement.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}