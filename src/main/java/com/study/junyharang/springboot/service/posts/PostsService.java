package com.study.junyharang.springboot.service.posts;

import com.study.junyharang.springboot.web.domain.posts.Posts;
import com.study.junyharang.springboot.web.domain.posts.PostsRepository;
import com.study.junyharang.springboot.web.dto.PostsResponseDto;
import com.study.junyharang.springboot.web.dto.PostsSaveRequestDto;
import com.study.junyharang.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor @Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    } // save() 끝

    @Transactional public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    } // update() 끝

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    } // findById () 끝
}
