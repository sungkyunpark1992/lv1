package com.sparta.lv1.dto;

import com.sparta.lv1.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String author;
    private String contents;
    private String password;

    public PostResponseDto(Post post){//이걸 왜 해야 하는지는 잘 모르겠다.
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.contents = post.getContents();
        this.password = post.getPassword();
    }



}
