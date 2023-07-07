package com.sparta.lv1.service;

import com.sparta.lv1.dto.PostRequestDto;
import com.sparta.lv1.dto.PostResponseDto;
import com.sparta.lv1.entity.Post;
import com.sparta.lv1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<PostResponseDto> getPosts() {
        //DB조회
        return postRepository.findAllByOrderByModifiedAtDesc().stream().map(PostResponseDto::new).toList();
    }
    public PostResponseDto createPost(PostRequestDto requestDto) {
        // RequestDto -> Entity
        Post post = new Post(requestDto);
        // DB 저장
        Post SavePost = postRepository.save(post);
        // Entity -> ResponseDto
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }
    public Long getPost(Long id) {//이게 맞나......??????
        Post post = findPost(id);
        return id;
    }
    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}
