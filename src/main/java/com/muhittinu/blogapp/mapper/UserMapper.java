package com.muhittinu.blogapp.mapper;

import com.muhittinu.blogapp.dto.request.userRequests.UserLoginRequestDto;
import com.muhittinu.blogapp.dto.request.userRequests.UserRegisterRequestDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserGetResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserLoginResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserRegisterResponseDto;
import com.muhittinu.blogapp.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User registerRequestDtoToUser (UserRegisterRequestDto dto);
    UserRegisterResponseDto userToRegisterResponseDto (User user);
    User loginDtoToUser (UserLoginRequestDto dto);
    UserLoginResponseDto userToLoginResponseDto(User user);

    UserGetResponseDto userToGetDto(User user);

}
