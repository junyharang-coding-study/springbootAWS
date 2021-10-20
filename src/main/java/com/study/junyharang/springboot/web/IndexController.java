package com.study.junyharang.springboot.web;

import com.study.junyharang.springboot.service.posts.PostsService;
import com.study.junyharang.springboot.web.dto.PostsResponseDto;
import com.study.junyharang.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor @Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    } // index() 끝

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    } // postsSave() 끝

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);

        model.addAttribute("posts", dto);

        return "posts-update";
    } // postsUpdate() 끝
} // class 끝
