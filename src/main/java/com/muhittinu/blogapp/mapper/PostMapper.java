package com.muhittinu.blogapp.mapper;

import com.muhittinu.blogapp.dto.request.postRequests.PostSaveRequestDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostGetAllResponseDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostGetResponseDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostSaveResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserGetResponseDto;
import com.muhittinu.blogapp.repository.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostGetResponseDto postToGetResponse(Post post);
    PostGetAllResponseDto postToGetAllResponse(Post post);

    Post postSaveRequestDtoToPost(PostSaveRequestDto dto);

    PostSaveResponseDto postToSaveResponse(Post post);
}
