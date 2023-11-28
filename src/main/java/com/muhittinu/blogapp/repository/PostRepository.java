package com.muhittinu.blogapp.repository;

import com.muhittinu.blogapp.dto.response.postResponses.PostGetResponseDto;
import com.muhittinu.blogapp.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByUserid(Long authorId);
    List<Post> findAllByCategoryName(String value);
    List<Post> findAllByContextContaining(String value);
    List<Post> findAllByCategoryId(Long value);
    List<Post> findAllByPublishedDateGreaterThan(Long value);
    List<Post> findAllByPublishedDate(Long value);

    List<Post> findAllByOrderByPublishedDate();
}
