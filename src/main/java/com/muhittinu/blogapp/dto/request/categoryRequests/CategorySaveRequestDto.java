package com.muhittinu.blogapp.dto.request.categoryRequests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorySaveRequestDto {
    private String name;
    private String description;
}
