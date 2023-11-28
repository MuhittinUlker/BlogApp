package com.muhittinu.blogapp.dto.response.postResponses;

import com.muhittinu.blogapp.repository.entity.Category;
import com.muhittinu.blogapp.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostGetAllResponseDto {
    private Long id;
    private String header;
    private Long userid;
    private Category category;
}
