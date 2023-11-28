package com.muhittinu.blogapp.dto.response.userResponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterResponseDto {
    private Long id;
    private String username;
    private String email;
    private Long registrationDate;
}
