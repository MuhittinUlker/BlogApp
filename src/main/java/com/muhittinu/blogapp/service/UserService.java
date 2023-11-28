package com.muhittinu.blogapp.service;

import com.muhittinu.blogapp.dto.request.userRequests.UserLoginRequestDto;
import com.muhittinu.blogapp.dto.request.userRequests.UserRegisterRequestDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserGetResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserLoginResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserRegisterResponseDto;
import com.muhittinu.blogapp.exception.BlogAppException;
import com.muhittinu.blogapp.exception.ErrorType;
import com.muhittinu.blogapp.mapper.UserMapper;
import com.muhittinu.blogapp.repository.UserRepository;
import com.muhittinu.blogapp.repository.entity.User;
import com.muhittinu.blogapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public List<UserGetResponseDto> getAll() {
        List<UserGetResponseDto> dtoList=new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            UserGetResponseDto userGetResponseDto = UserMapper.INSTANCE.userToGetDto(user);
            dtoList.add(userGetResponseDto);
        });
        return dtoList;
    }

    public UserGetResponseDto getById(Long value) {
        Optional<User> byId = userRepository.findById(value);
        if (byId.isPresent()) {
            return UserMapper.INSTANCE.userToGetDto(byId.get());
        }else {
            throw new BlogAppException(ErrorType.KULLANICI_BULUNAMADI);
        }
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto dto) {
        User user = UserMapper.INSTANCE.registerRequestDtoToUser(dto);
        if (!userRepository.existsByEmail(user.getEmail())){
            userRepository.save(user);
            return UserMapper.INSTANCE.userToRegisterResponseDto(user);
        }else {
            throw new BlogAppException(ErrorType.KULLANICI_ZATEN_KAYITLI);
        }
    }

    public UserLoginResponseDto login(UserLoginRequestDto dto) {
        User user = UserMapper.INSTANCE.loginDtoToUser(dto);
        if (userRepository.existsByEmail(user.getEmail())){
            User loggedInUser = userRepository.findByEmail(user.getEmail());
            if (loggedInUser.getPassword().equals(dto.getPassword())){
                return UserMapper.INSTANCE.userToLoginResponseDto(loggedInUser);
            }else {
                throw new BlogAppException(ErrorType.PARAMETRELER_YANLIS);
            }
        }else {
            throw new BlogAppException(ErrorType.PARAMETRELER_YANLIS);
        }
    }
}
