package com.muhittinu.blogapp.dto.request.userRequests;

import com.muhittinu.blogapp.customannotations.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterRequestDto {
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(unique = true, length = 50)
    private String username;
    @Email
    @Column(unique = true)
    private String email;
    @ValidPassword
    private String password;
    private String rePassword;
}
