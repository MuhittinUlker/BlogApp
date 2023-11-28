package com.muhittinu.blogapp.dto.request.postRequests;

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
public class PostSaveRequestDto {
    private String header;
    private String context;
    @Builder.Default
    private Long date = System.currentTimeMillis();
    private Long userid;
    private Category category;
}
