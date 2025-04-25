package com.example.likeandcommentmanagement.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String content;
    private int likes = 0;
    private List<Comment> comments = new ArrayList<>();
}
