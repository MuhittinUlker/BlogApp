package com.muhittinu.blogapp.dto.response.postResponses;

import com.muhittinu.blogapp.repository.entity.Category;
import com.muhittinu.blogapp.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostGetResponseDto {
    private Long id;
    private String header;
    private String context;
    private Long date;
    private Long userid;
    private Category category;

}
