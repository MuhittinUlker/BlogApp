package com.muhittinu.blogapp.controller;

import com.muhittinu.blogapp.dto.request.postRequests.PostSaveRequestDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostGetAllResponseDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostGetResponseDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostSaveResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserGetResponseDto;
import com.muhittinu.blogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.muhittinu.blogapp.constant.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    @PostMapping(SAVE)
    public ResponseEntity<PostSaveResponseDto> save(PostSaveRequestDto dto){
        return ResponseEntity.ok(postService.createPost(dto));
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(Long id){
        postService.deleteById(id);
        return ResponseEntity.ok("Silme islemi basarili");
    }
    @GetMapping(GETALL)
    public ResponseEntity<List<PostGetAllResponseDto>> getAll(){
        return ResponseEntity.ok(postService.getAll());
    }
    @GetMapping(GETBYID)
    public ResponseEntity<PostGetResponseDto> getById(Long value){
        return ResponseEntity.ok(postService.getById(value));
    }
    @GetMapping("/getAllByAuthorId")
    public ResponseEntity<List<PostGetResponseDto>> getAllByAuthorId(Long userid){
        return ResponseEntity.ok(postService.getAllByAuthorId(userid));
    }
    @GetMapping("getAllByCategoryName")
    public ResponseEntity<List<PostGetResponseDto>> getAllByCategoryName  (String value){
        return ResponseEntity.ok(postService.getAllByCategoryName(value));
    }
    @GetMapping("getAllByCategoryId")
    public ResponseEntity<List<PostGetResponseDto>> getAllByCategoryId(Long value){
        return ResponseEntity.ok(postService.getAllByCategoryId(value));
    }
    @GetMapping("/findByContext")
    public ResponseEntity<List<PostGetResponseDto>> findAllByContext(String value){
        return ResponseEntity.ok(postService.findAllByContext(value));
    }
    @GetMapping("/findAllByPublishedDate")
    public ResponseEntity<List<PostGetResponseDto>> findAllByPublishedDate(Long value){
        return ResponseEntity.ok(postService.findAllByPublishedDate(value));
    }
    @GetMapping("/findAllByPublishedDateGreaterThan")
    public ResponseEntity<List<PostGetResponseDto>> findAllByPublishedDateGreaterThan(Long value){
        return ResponseEntity.ok(postService.findAllByPublishedDateGreaterThan(value));
    }

}
