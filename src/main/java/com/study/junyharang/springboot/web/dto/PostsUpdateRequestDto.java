package com.study.junyharang.springboot.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String content;

    @Builder public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    } // 생성자 끝
} // class 끝
