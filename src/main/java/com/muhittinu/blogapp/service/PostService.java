package com.muhittinu.blogapp.service;

import com.muhittinu.blogapp.dto.request.postRequests.PostSaveRequestDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostGetAllResponseDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostGetResponseDto;
import com.muhittinu.blogapp.dto.response.postResponses.PostSaveResponseDto;
import com.muhittinu.blogapp.dto.response.userResponses.UserGetResponseDto;
import com.muhittinu.blogapp.exception.BlogAppException;
import com.muhittinu.blogapp.exception.ErrorType;
import com.muhittinu.blogapp.mapper.PostMapper;
import com.muhittinu.blogapp.repository.PostRepository;
import com.muhittinu.blogapp.repository.entity.Post;
import com.muhittinu.blogapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService extends ServiceManager<Post,Long> {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        super(postRepository);
        this.postRepository = postRepository;
    }

    public List<PostGetAllResponseDto> getAll() {
        List<PostGetAllResponseDto> dtoList=new ArrayList<>();
        postRepository.findAll().forEach(post->dtoList.add(PostMapper.INSTANCE.postToGetAllResponse(post)));
        return dtoList;
    }

    public PostGetResponseDto getById(Long value) {
        if (postRepository.findById(value).isPresent()){
            return PostMapper.INSTANCE.postToGetResponse(postRepository.findById(value).get());
        }else {
            throw new BlogAppException(ErrorType.POST_BULUNAMADI);
        }
    }

    public PostSaveResponseDto createPost(PostSaveRequestDto dto) {
        return PostMapper.INSTANCE.postToSaveResponse(
                postRepository.save(PostMapper.INSTANCE.postSaveRequestDtoToPost(dto)));
    }

    public List<PostGetResponseDto> getAllByAuthorId(Long userid) {
        List<PostGetResponseDto> dtoList=new ArrayList<>();
        postRepository.findAllByUserid(userid).forEach(post -> {
            PostGetResponseDto postGetResponseDto = PostMapper.INSTANCE.postToGetResponse(post);
            dtoList.add(postGetResponseDto);
        });
        return dtoList;
    }

    public List<PostGetResponseDto> getAllByCategoryName(String value) {
        List<PostGetResponseDto> dtoList=new ArrayList<>();
        postRepository.findAllByCategoryName(value).forEach(post -> {
            PostGetResponseDto postGetResponseDto = PostMapper.INSTANCE.postToGetResponse(post);
            dtoList.add(postGetResponseDto);
        });
        return dtoList;
    }

    public List<PostGetResponseDto> findAllByContext(String value) {
        List<PostGetResponseDto> dtoList=new ArrayList<>();
        postRepository.findAllByContextContaining(value).forEach(post -> {
            PostGetResponseDto postGetResponseDto = PostMapper.INSTANCE.postToGetResponse(post);
            dtoList.add(postGetResponseDto);
        });
        return dtoList;
    }

    public List<PostGetResponseDto> getAllByCategoryId(Long value) {
        List<PostGetResponseDto> dtoList=new ArrayList<>();
        postRepository.findAllByCategoryId(value).forEach(post -> {
            PostGetResponseDto postGetResponseDto = PostMapper.INSTANCE.postToGetResponse(post);
            dtoList.add(postGetResponseDto);
        });
        return dtoList;
    }

    public List<PostGetResponseDto> findAllByPublishedDateGreaterThan(Long value) {
        List<PostGetResponseDto> dtoList = new ArrayList<>();
        postRepository.findAllByPublishedDateGreaterThan(value).forEach(post->{
           dtoList.add(PostMapper.INSTANCE.postToGetResponse(post));
        });
        return dtoList;
    }

    public List<PostGetResponseDto> findAllByPublishedDate(Long value) {
        List<PostGetResponseDto> dtoList = new ArrayList<>();
        postRepository.findAllByPublishedDate(value).forEach(post->{
            dtoList.add(PostMapper.INSTANCE.postToGetResponse(post));
        });
        return dtoList;
    }

    public List<PostGetResponseDto> findAllByOrderByPublishedDateDesc(){
        List<PostGetResponseDto> dtoList = new ArrayList<>();
        postRepository.findAllByOrderByPublishedDate().forEach(post->{
            dtoList.add(PostMapper.INSTANCE.postToGetResponse(post));
        });
        return dtoList;
    }
}
