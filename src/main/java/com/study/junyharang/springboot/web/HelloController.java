package com.study.junyharang.springboot.web;

import com.study.junyharang.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController = 컨트롤러를 JSON으로 반환하는 컨트롤러로 만든다.
@RestController public class HelloController {

    // @GetMapping = HTTP Method인 GET의 요청을 받을 수 있는 API 생성을 위해 사용
    @GetMapping("/hello") public String hello() {
        return "hello";
    } // hello() 끝

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(
            @RequestParam("name") String name,
            @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    } // helloDto() 끝

} // class 끝
