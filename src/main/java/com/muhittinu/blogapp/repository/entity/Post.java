package com.muhittinu.blogapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 220)
    private String header;
    @Column(length = 2048)
    private String context;
    @Builder.Default
    private Long publishedDate = System.currentTimeMillis();
    private Long userid;
    @ManyToOne
    private Category category;
    @OneToMany
    private List<User> likes;
    @OneToMany
    private List<Comment> comments;
}
