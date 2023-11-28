package com.muhittinu.blogapp.dto.response.categoryResponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryGetAllResponseDto {
    private Long id;
    private String name;
    private String description;
}
