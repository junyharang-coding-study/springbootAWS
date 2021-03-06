package com.study.junyharang.springboot.web.domain.user;

import com.study.junyharang.springboot.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.study.junyharang.springboot.web.domain.user.Role;
import javax.persistence.*;

@Getter @NoArgsConstructor @Entity
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column private String picture;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Role role;


    @Builder public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    } // 생성자 끝

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    } // update() 끝

    public String getRoleKey() {
        return this.role.getKey();
    } // getRoleKey() 끝
} // class 끝
