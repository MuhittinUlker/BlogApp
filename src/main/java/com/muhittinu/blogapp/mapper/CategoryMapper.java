package com.muhittinu.blogapp.mapper;

import com.muhittinu.blogapp.dto.request.categoryRequests.CategorySaveRequestDto;
import com.muhittinu.blogapp.dto.response.categoryResponses.CategoryGetAllResponseDto;
import com.muhittinu.blogapp.dto.response.categoryResponses.CategorySaveResponseDto;
import com.muhittinu.blogapp.repository.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    Category saveDtoToCategory(CategorySaveRequestDto dto);

    CategoryGetAllResponseDto categoryToGetAllDto(Category category);

    CategorySaveResponseDto categoryToSaveResponseDto(Category category);
}
