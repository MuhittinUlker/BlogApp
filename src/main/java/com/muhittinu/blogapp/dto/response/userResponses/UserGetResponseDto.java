package com.muhittinu.blogapp.dto.response.userResponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGetResponseDto {
    private Long id;
    private String username;
    private String photo;
    private String firstName;
    private String lastName;
}
