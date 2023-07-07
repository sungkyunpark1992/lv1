package com.sparta.lv1.controller;
import com.sparta.lv1.dto.PostRequestDto;
import com.sparta.lv1.dto.PostResponseDto;
import com.sparta.lv1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor//생성자를 만들어주는애
@RestController//@Controller라는 주문을 외쳐야 controller기능을 할수있다. 잘 모르니 일단 그렇게하고 넘어간다. 그런데 왜 Controller가 아니라 RestController인 거지?
@RequestMapping("/api")
public class PostController {
/*    //api를 받기 위해서는 메서드랑 url이 필요하다.
    //조회 : GET
    //작성 : POST
    //수정 : PUT
    //삭제 : DELETE
    //url은 자원을 명시해준다.(자원 = 구현 및 실행의 대상)
    //메소드에는 행동을 명시해준다.
    @GetMapping("/api/post")
    public List<PostResponseDto> getPosts(){//전체 게시글 목록 조회 api에서 필요한 데이타:제목,작성자명,내용,날짜->이런 것들을 한번에 담을수 있는 타입이 필요 = PostResponseDto타입을 만들자
        //위의 정보들을 어디선가 가져와야 하지 않을까?-> db에서 가져와야 겠다.-> db에 접근하기 위한 설정들을 세팅(라이브러리설치, db접근정보 입력등)
        return List<PostResponseDto>;
    }
    @PostMapping("/api/post") public void creatPosts(){}
    @GetMapping("/api/post/{id}") public void getPostById(){}
    @PutMapping("/api/put/{id}") public void updatePost(){}
    @DeleteMapping("/api/delete/{id}") public void deletePost(){}*///정공법으로 만들려면 이렇게 주석처리대로 만드는게 맞지만 시간이 너무 없다. 꼼수를 쓰자. 메모장을 복붙하자.
    private final PostService postService;
    /*public PostController(PostService postService) {
        this.postService = postService;
    }*///@RequiredArgsConstructor가 없다면 이렇게 PostService postService를 인자로 받는 PostController 생정자를 만들어야 한다.
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }
    @GetMapping("/posts/{id}")//이게 맞나......??????
    public Long getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }


}
