package com.example.likeandcommentmanagement.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private String id;
    private String text;
    private String author;
}