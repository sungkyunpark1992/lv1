package com.sparta.lv1.entity;

import com.sparta.lv1.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "blogpost") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Post extends Timestamped{//왜 여기에 다른 변수가 다 있는데 작성날짜는 변수로 따로 안들어가는거지?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "password", nullable = false)
    private String password;

    public Post(PostRequestDto requestDto){//PostService클래스에서 createPost 메소드 안에 생성자 호출부분
//Post post = new Post(requestDto);에서 호출할때 requestDto 부분이 생성자로 정의가 되어야한다는건 알겠다. 그런데 뭘로 초기화시켜줘야 하는지는 모르겠다. 그래서 복붙
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContent();
        this.password = requestDto.getPassword();

    }


}
