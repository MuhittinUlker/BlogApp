package com.muhittinu.blogapp.controller;

import com.muhittinu.blogapp.dto.request.categoryRequests.CategorySaveRequestDto;
import com.muhittinu.blogapp.dto.response.categoryResponses.CategoryGetAllResponseDto;
import com.muhittinu.blogapp.dto.response.categoryResponses.CategorySaveResponseDto;
import com.muhittinu.blogapp.repository.entity.Category;
import com.muhittinu.blogapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.muhittinu.blogapp.constant.EndPoints.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping(SAVE)
    public ResponseEntity<CategorySaveResponseDto> save(CategorySaveRequestDto dto){
        return ResponseEntity.ok(categoryService.saveDto(dto));
    }
    @GetMapping(GETALL)
    public ResponseEntity<List<CategoryGetAllResponseDto>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }
    @GetMapping(GETBYID)
    public ResponseEntity<CategoryGetAllResponseDto> getById(Long value){
        return ResponseEntity.ok(categoryService.getById(value));
    }
    @GetMapping("/GetByName")
    public ResponseEntity<CategoryGetAllResponseDto> getByName(String value){
        return ResponseEntity.ok(categoryService.getByName(value));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<String> deleteById(Long value){
        categoryService.deleteById(value);
        return ResponseEntity.ok("Silme islemi basarili");
    }
}
