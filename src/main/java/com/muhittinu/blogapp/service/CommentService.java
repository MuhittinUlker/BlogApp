package com.muhittinu.blogapp.service;

import com.muhittinu.blogapp.repository.CommentRepository;
import com.muhittinu.blogapp.repository.entity.Comment;
import com.muhittinu.blogapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceManager<Comment,Long> {
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository=commentRepository;
    }
}
