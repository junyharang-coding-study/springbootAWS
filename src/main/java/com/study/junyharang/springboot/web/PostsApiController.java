package com.study.junyharang.springboot.web;

import com.study.junyharang.springboot.service.posts.PostsService;
import com.study.junyharang.springboot.web.dto.PostsResponseDto;
import com.study.junyharang.springboot.web.dto.PostsSaveRequestDto;
import com.study.junyharang.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor @RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    } // save() 끝

    @PutMapping("/api/v1/posts/{id}")
    public Long update (@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    } // update() 끝

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    } // findById() 끝

} // class 끝
