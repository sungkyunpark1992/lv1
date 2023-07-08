package com.sparta.lv1.service;

import com.sparta.lv1.dto.PostRequestDto;
import com.sparta.lv1.dto.PostResponseDto;
import com.sparta.lv1.entity.Post;
import com.sparta.lv1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        // 해당 메모가 DB에 존재하는지 확인
        Post post = findPost(id);
        return id;
    }
    @Transactional//updatePost에는 이 @Transactional이 붙는다. 왜??????
    public Long updatePost(Long id, PostRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Post post = findPost(id);//createPost안에 Post에 대한 인스턴스화가 진행 되었기 때문에 여기선 따로 new가 필요 없는 것? 근데 저건 createPost안에서 인스턴스화가 된거라 저 메소드 호출이 끝나면 변수처럼 없어지는것 아닌가? 메소드 바깥에서 인스턴스화 시켜야 되는것 아닌가?
        // post 내용 수정
        post.update(requestDto);
        return id;
    }
    public Long deletePost(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Post post = findPost(id);
        // memo 삭제
        postRepository.delete(post);
        return id;
    }
    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }



}
