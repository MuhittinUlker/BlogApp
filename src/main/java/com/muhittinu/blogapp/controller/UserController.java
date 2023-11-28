package com.muhittinu.blogapp.controller;

import com.muhittinu.blogapp.dto.request.userRequests.UserLoginRequestDto;
import com.muhittinu.blogapp.dto.request.userRequests.UserRegisterRequestDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserGetResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserLoginResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserRegisterResponseDto;
import com.muhittinu.blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.muhittinu.blogapp.constant.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ROOT+USER)
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody @Validated UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.register(dto));
    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto dto){
        return ResponseEntity.ok(userService.login(dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("Silme islemi basarili");
    }
    @GetMapping(GETALL)
    public ResponseEntity<List<UserGetResponseDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping(GETBYID)
    public ResponseEntity<UserGetResponseDto> getById(Long value){
        return ResponseEntity.ok(userService.getById(value));
    }
}
