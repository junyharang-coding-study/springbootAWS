package com.study.junyharang.springboot.web;

import com.study.junyharang.springboot.config.auth.LoginUser;
import com.study.junyharang.springboot.config.auth.dto.SessionUser;
import com.study.junyharang.springboot.service.posts.PostsService;
import com.study.junyharang.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor @Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) { // 세션에 저장된 user가 null이 아니라면?
            model.addAttribute("userName", user.getName());
        } // if문 끝

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
