package com.muhittinu.blogapp.service;

import com.muhittinu.blogapp.dto.request.categoryRequests.CategorySaveRequestDto;
import com.muhittinu.blogapp.dto.response.categoryResponses.CategoryGetAllResponseDto;
import com.muhittinu.blogapp.dto.response.categoryResponses.CategorySaveResponseDto;
import com.muhittinu.blogapp.exception.BlogAppException;
import com.muhittinu.blogapp.exception.ErrorType;
import com.muhittinu.blogapp.mapper.CategoryMapper;
import com.muhittinu.blogapp.repository.CategoryRepository;
import com.muhittinu.blogapp.repository.entity.Category;
import com.muhittinu.blogapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends ServiceManager<Category,Long> {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    public CategoryGetAllResponseDto getById(Long value) {
        Category category=new Category();
        if (categoryRepository.findById(value).isPresent()){
            return CategoryMapper.INSTANCE.categoryToGetAllDto(categoryRepository.findById(value).get());
        }else {
            throw new BlogAppException(ErrorType.CATEGORY_BULUNAMADI);
        }
    }

    public CategorySaveResponseDto saveDto(CategorySaveRequestDto dto) {
       return CategoryMapper.INSTANCE.categoryToSaveResponseDto(
               categoryRepository.save(CategoryMapper.INSTANCE.saveDtoToCategory(dto)));
    }

    public List<CategoryGetAllResponseDto> getAll() {
        List<CategoryGetAllResponseDto> dtoList=new ArrayList<>();
        categoryRepository.findAll()
                .forEach(category -> dtoList
                        .add(CategoryMapper.INSTANCE.categoryToGetAllDto(category)));
        return dtoList;
    }

    @Override
    public void deleteById(Long value) {
        if (categoryRepository.existsById(value)){
        super.deleteById(value);
        }else {
            throw new BlogAppException(ErrorType.CATEGORY_BULUNAMADI);
        }
    }

    public CategoryGetAllResponseDto getByName(String value) {
        Category category=new Category();
        if (categoryRepository.findByName(value).isPresent()){
            return CategoryMapper.INSTANCE.categoryToGetAllDto(categoryRepository.findByName(value).get());
        }else {
            throw new BlogAppException(ErrorType.CATEGORY_BULUNAMADI);
        }
    }
}
